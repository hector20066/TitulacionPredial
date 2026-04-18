package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.ResolutionNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.ResolutionPersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of {@link DAOResolution} that manages
 * resolution-related persistence operations.
 *
 * <p>
 * This class belongs to the data access layer (DAO) and is
 * responsible for executing CRUD operations against the database
 * using JDBC and external SQL statements obtained from {@link SQLRepository}.
 * </p>
 *
 * <p>
 * Connections are obtained using {@link DataBasePool}, ensuring the use
 * of a connection pool to improve performance and resource management.
 * </p>
 *
 * <p>
 * Implement the Singleton pattern to ensure a single shared instance
 * within the application context.
 * </p>
 *
 * <p><strong>Error handling:</strong></p>
 * <ul>
 *     <li>Throws {@link ResolutionPersistenceException} on SQL errors.</li>
 *     <li>Throws {@link ResolutionNotFoundException} when no expected records are found.</li>
 *     <li>Propagate {@link DAOException} as a general contract of the DAO layer.</li>
 * </ul>
 *
 * <p>
 * This class does not contain business logic; it only performs data access operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DAOResolutionImpl implements DAOResolution {

    private static final LanguageManager lang = LanguageManager.getInstance();
    private static DAOResolutionImpl instance;

    /**
     * Private builder to guarantee the Singleton pattern.
     */
    private DAOResolutionImpl() {

    }

    /**
     * Obtain the single instance of the DAO.
     *
     * @return Singleton instance of {@code DAOResolutionImpl}
     */
    public static synchronized DAOResolutionImpl getInstance() {
        if (instance == null) {
            instance = new DAOResolutionImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOResolutionCreate dto) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, dto.getResolutionNumber());
            st.setDate(2, Date.valueOf(dto.getNotification()));
            st.setDate(3, Date.valueOf(dto.getExecutory()));
            st.setString(4, dto.getFmi());
            st.setString(5, dto.getAct());
            st.setString(6, dto.getPublicWriting());
            st.setString(7, dto.getNotary());
            st.setString(8, dto.getBeneficiaryName());
            st.setInt(9, dto.getPropertyCode());
            
            int affectedRows = st.executeUpdate();

            if (affectedRows == 0) {
                throw new ResolutionPersistenceException(lang.message("persistence.resolution.register"), null);
            }
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(lang.message("persistence.resolution.register"), e);
        }
    }

    @Override
    public DTOResolutionDetails findByCode(int numResolution) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, numResolution);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                DTOResolutionDetails dto = new DTOResolutionDetails();
                executeQuery(dto, rs);
                return dto;
            }
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(lang.message("persistence.resolution.info.number") + " " + numResolution, e);
        }
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws DAOException {
        List<DTOResolutionDetails> list = new ArrayList<>();
        String sql = SQLRepository.get("sql/resolution/findByAll.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                DTOResolutionDetails dto = new DTOResolutionDetails();
                executeQuery(dto, rs);
                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(lang.message("persistence.resolution.info.all"), e);
        }
    }

    @Override
    public List<DTOResolutionDetails> findByMunicipality(Municipalities municipality) throws DAOException {
        List<DTOResolutionDetails> list = new ArrayList<>();
        String sql = SQLRepository.get("sql/resolution/findByMunicipality.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, String.valueOf(municipality));

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    DTOResolutionDetails dto = new DTOResolutionDetails();
                    executeQuery(dto, rs);
                    list.add(dto);
                }

                return list;
            }
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(
                    lang.message("persistence.resolution.info.municipality") + " " + municipality, e);
        }
    }

    /**
     * Configure the DTO with the resolution data obtained from
     * the {@link ResultSet}.
     *
     * @param dto object where the obtained data will be stored
     * @param rs  query results
     * @throws SQLException If an error occurs while reading the
     *                      data from the {@code ResultSet}
     */
    private void executeQuery(DTOResolutionDetails dto, ResultSet rs) throws SQLException {
        dto.setCode(rs.getInt("code"));
        dto.setResolutionNumber(rs.getLong("num_resolution"));
        
        Date notificationDate = rs.getDate("notification");
        dto.setNotification(notificationDate != null ? notificationDate.toLocalDate() : null);
        
        Date executoryDate = rs.getDate("executory");
        dto.setExecutory(executoryDate != null ? executoryDate.toLocalDate() : null);
        
        dto.setFmi(rs.getString("fmi"));
        dto.setAct(rs.getString("act"));
        dto.setPublicWriting(rs.getString("public_writing"));
        dto.setNotary(rs.getString("notary"));
        dto.setBeneficiaryName(rs.getString("beneficiary_name"));
    }

    @Override
    public boolean modify(DTOResolutionUpdate dto) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/modify.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setDate(1, Date.valueOf(dto.getExecutory()));
            st.setString(2, dto.getAct());
            st.setString(3, dto.getPublicWriting());
            st.setDate(4, Date.valueOf(dto.getNotification()));
            st.setLong(5, dto.getResolutionNumber());
            st.setString(6, dto.getFmi());
            st.setString(7, dto.getNotary());
            st.setInt(8, dto.getCode());

            if (st.executeUpdate() == 0) {
                throw new ResolutionNotFoundException(String.valueOf(dto.getResolutionNumber()));
            }

            return true;
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(lang.message("persistence.resolution.info.number") + " "
                    + dto.getResolutionNumber(), e);
        }
    }

    @Override
    public int countRecords() throws DAOException {
        String sql = SQLRepository.get("sql/resolution/countRecords.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new ResolutionNotFoundException(lang.message("not.found.count"));
            }

            return rs.getInt("total_records");
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(lang.message("persistence.resolution.info.all"), e);
        }
    }

    @Override
    public int countRecordsByMunicipality(Municipalities municipality) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/countRecordsByMunicipality.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, municipality.getValue());

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    throw new ResolutionNotFoundException(lang.message("not.found.count"));
                }

                return rs.getInt("total_records");
            }
        } catch (SQLException e) {
            throw new ResolutionPersistenceException(lang.message("persistence.resolution.info.all"), e);
        }
    }

}
