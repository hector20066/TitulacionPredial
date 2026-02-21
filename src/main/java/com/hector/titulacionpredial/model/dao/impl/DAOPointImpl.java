package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.point.DTOPointCreate;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

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
    public void add(DTOPointCreate dto) throws Exception {
        String sql = "INSERT INTO point(number, north_coordinate, east_coordinate, distance, hillside, property_code) VALUES(?, ?, ?, ?, ?, ?);";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setInt(1, dto.getNumberPoint());
             st.setDouble(2, dto.getNorthCoordinate());
             st.setDouble(3, dto.getEastCoordinate());
             st.setDouble(4, dto.getDistance());
             st.setString(5, dto.getHillside());
             st.setInt(6, dto.getPropertyCode());
             st.executeUpdate();
        }
    }

    @Override
    public DTOPointDetails findById(int id) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public DTOPointDetails findByCode(int propertyCode) throws Exception {
        String sql = "SELECT number, north_coordinate, east_coordinate, distance, hillside FROM point WHERE property_code = ? LIMIT 1;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, propertyCode);

            try(ResultSet rs = st.executeQuery()) {
                if(!rs.next()) {
                    return null;
                }

                DTOPointDetails dto = new DTOPointDetails();
                executeQuery(dto, rs);
                return dto;
            }
        }
    }

    private void executeQuery(DTOPointDetails dto, ResultSet rs) throws Exception {
        dto.setNumberPoint(rs.getInt("number"));
        dto.setNorthCoordinate(rs.getDouble("north_coordinate"));
        dto.setEastCoordinate(rs.getDouble("east_coordinate"));
        dto.setDistance(rs.getDouble("distance"));
        dto.setHillside(rs.getString("hillside"));
    }

}
