package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.persistence.PointPersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of the DAO for the management of geographic points
 * (coordinates) in the MySQL database.
 *
 * <p>
 * It uses the Singleton pattern to ensure a single instance. SQL
 * queries are obtained from {@link SQLRepository} and the database
 * connection is made via {@link DataBasePool}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOPoint
 * @see DataBasePool
 * @see SQLRepository
 * @since 1.0
 */
public class DAOPointImpl implements DAOPoint {

    private static final LanguageManager lang = LanguageManager.getInstance();
    private static DAOPointImpl instance;

    /**
     * Private builder to guarantee the Singleton pattern.
     */
    private DAOPointImpl() {

    }

    /**
     * Obtain the single instance of the DAO.
     *
     * @return Singleton instance of {@code DAOPointImpl}
     */
    public static DAOPointImpl getInstance() {
        if (instance == null) {
            instance = new DAOPointImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOPoint dto) throws DAOException {
        String sql = SQLRepository.get("sql/point/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, dto.getNumberPoint());
            st.setDouble(2, dto.getNorthCoordinate());
            st.setDouble(3, dto.getEastCoordinate());
            st.setDouble(4, dto.getDistance());
            st.setString(5, dto.getHillside());
            st.setInt(6, dto.getPropertyCode());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new PointPersistenceException(lang.message("persistence.point.register"), e);
        }
    }

    @Override
    public DTOPoint findByCode(int propertyCode) throws DAOException {
        String sql = SQLRepository.get("sql/point/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, propertyCode);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                DTOPoint dto = new DTOPoint();
                executeQuery(dto, rs);
                return dto;
            }
        } catch (SQLException e) {
            throw new PointPersistenceException(lang.message("persistence.point.info.property.code") + " " + propertyCode, e);
        }
    }

    /**
     * Configure the DTO with the point data obtained from the {@link ResultSet}.
     *
     * @param dto object where the obtained data will be stored
     * @param rs  query results
     * @throws SQLException If an error occurs while reading the data
     * from the {@code ResultSet}
     */
    private void executeQuery(DTOPoint dto, ResultSet rs) throws SQLException {
        dto.setNumberPoint(rs.getInt("number"));
        dto.setNorthCoordinate(rs.getDouble("north_coordinate"));
        dto.setEastCoordinate(rs.getDouble("east_coordinate"));
        dto.setDistance(rs.getDouble("distance"));
        dto.setHillside(rs.getString("hillside"));
    }

}
