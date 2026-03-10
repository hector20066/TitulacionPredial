package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.SpouseNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.SpousePersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of the DAO for spouse management in the MySQL database.
 *
 * <p>
 * It uses the Singleton pattern to ensure a single instance. SQL queries
 * are obtained from {@link SQLRepository} and the database connection is
 * made via {@link DataBasePool}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOSpouse
 * @see DataBasePool
 * @see SQLRepository
 * @since 1.0
 */
public class DAOSpouseImpl implements DAOSpouse {

    private static final LanguageManager lang = LanguageManager.getInstance();
    private static DAOSpouseImpl instance;

    /**
     * Private builder to guarantee the Singleton pattern.
     */
    private DAOSpouseImpl() {

    }

    /**
     * Obtain the single instance of the DAO.
     *
     * @return Singleton instance of {@code DAOSpouseImpl}
     */
    public static DAOSpouseImpl getInstance() {
        if (instance == null) {
            instance = new DAOSpouseImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOSpouse dto) throws DAOException {
        String sql = SQLRepository.get("sql/spouse/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, dto.getId());
            st.setString(2, dto.getFullName());
            st.setString(3, dto.getExpeditionLocation());
            st.setString(4, dto.getAddress());
            st.setLong(5, dto.getPhone());
            st.setInt(6, dto.getBeneficiaryCode());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new SpousePersistenceException(lang.message("persistence.spouse.register"), e);
        }
    }

    @Override
    public DTOSpouse findByCode(int id) throws DAOException {
        String sql = SQLRepository.get("sql/spouse/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                DTOSpouse dto = new DTOSpouse();
                executeQuery(dto, rs);
                return dto;
            }
        } catch (SQLException e) {
            throw new SpousePersistenceException(lang.message("persistence.spouse.info.id") + " " + id, e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String sql = SQLRepository.get("sql/spouse/delete.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, id);

            if (st.executeUpdate() == 0) {
                throw new SpouseNotFoundException(String.valueOf(id));
            }
        } catch (SQLException e) {
            throw new SpousePersistenceException(lang.message("persistence.spouse.info"), e);
        }
    }

    /**
     * Configure the DTO with the spouse's data obtained from
     * the {@link ResultSet}.
     *
     * @param dto object where the obtained data will be stored
     * @param rs  query results
     * @throws SQLException If an error occurs while reading
     *                      the data from the {@code ResultSet}
     */
    private void executeQuery(DTOSpouse dto, ResultSet rs) throws SQLException {
        dto.setId(rs.getLong("id"));
        dto.setFullName(rs.getString("full_name"));
        dto.setExpeditionLocation(rs.getString("expedition_location"));
        dto.setAddress(rs.getString("address"));
        dto.setPhone(rs.getLong("phone"));
        dto.setBeneficiaryCode(rs.getInt("beneficiary_code"));
    }

}
