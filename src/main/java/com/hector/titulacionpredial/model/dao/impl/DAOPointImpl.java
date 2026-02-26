package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.persistence.PointPersistenceException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;

/**
 *
 * @author hectoracevedo
 */
public class DAOPointImpl implements DAOPoint {

    private static DAOPointImpl instance;

    private DAOPointImpl() {

    }

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
            throw new PointPersistenceException("No fue posible guardar la información del punto", e);
        }
    }

    @Override
    public DTOPoint findByCode(int propertyCode) throws DAOException {
        String sql = SQLRepository.get("sql/point/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, propertyCode);

            try(ResultSet rs = st.executeQuery()) {
                if(!rs.next()) {
                    return null;
                }

                DTOPoint dto = new DTOPoint();
                executeQuery(dto, rs);
                return dto;
            }
        } catch (SQLException e) {
            throw new PointPersistenceException("Error al recuperar la información del punto de la propiedad con código: " + propertyCode, e);
        }
    }

    private void executeQuery(DTOPoint dto, ResultSet rs) throws SQLException {
        dto.setNumberPoint(rs.getInt("number"));
        dto.setNorthCoordinate(rs.getDouble("north_coordinate"));
        dto.setEastCoordinate(rs.getDouble("east_coordinate"));
        dto.setDistance(rs.getDouble("distance"));
        dto.setHillside(rs.getString("hillside"));
    }

}
