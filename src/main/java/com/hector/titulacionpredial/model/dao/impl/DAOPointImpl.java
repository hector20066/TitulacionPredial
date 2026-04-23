package com.hector.titulacionpredial.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.persistence.PointPersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.utils.SQLRepository;

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
    public static synchronized DAOPointImpl getInstance() {
        if (instance == null) {
            instance = new DAOPointImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOPoint dto) throws DAOException {
        String sql = SQLRepository.get("sql/point/insert.sql");
        Connection connection = null;

        try {
            connection = DataBasePool.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setInt(1, dto.getNumberPoint());
                st.setString(2, dto.getNorthCoordinate());
                st.setString(3, dto.getEastCoordinate());
                st.setDouble(4, dto.getDistance());
                st.setString(5, dto.getHillside());
                st.setInt(6, dto.getPropertyCode());
                st.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    lang.message("error.rollback");
                }
            }
            throw new PointPersistenceException(lang.message("persistence.point.register"), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    lang.message("error.close.connection");
                }
            }
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
     *                      from the {@code ResultSet}
     */
    private void executeQuery(DTOPoint dto, ResultSet rs) throws SQLException {
        dto.setNumberPoint(rs.getInt("number"));
        dto.setNorthCoordinate(rs.getString("north_coordinate"));
        dto.setEastCoordinate(rs.getString("east_coordinate"));
        dto.setDistance(rs.getDouble("distance"));
        dto.setHillside(rs.getString("hillside"));
    }

    @Override
    public Set<Integer> existingPointNumber(int propertyCode) throws DAOException {
        Set<Integer> existingPoint = new HashSet<>();
        String sql = SQLRepository.get("sql/point/existingPointNumber.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, propertyCode);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    int pointNumber = rs.getInt("number");
                    existingPoint.add(pointNumber);
                }

                return existingPoint;
            }
        } catch (SQLException e) {
            throw new PointPersistenceException(lang.message("persistence.point.info.property.code") + " " + propertyCode, e);
        }
    }

}
