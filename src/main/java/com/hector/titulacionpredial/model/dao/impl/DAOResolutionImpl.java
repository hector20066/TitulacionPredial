package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DAOResolutionImpl implements DAOResolution {

    private static DAOResolutionImpl instance;

    private DAOResolutionImpl() {

    }

    public static DAOResolutionImpl getInstance() {
        if (instance == null) {
            instance = new DAOResolutionImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOResolutionCreate dto) throws Exception {
        String sql = "INSERT INTO resolution(num_resolution, notification, executory, fmi, act, public_writing, notary, beneficiary_name, property_code) VALUES(?, ?, ?, ?, ? ,?, ?, ?, ?);";

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
            st.executeUpdate();
        }
    }

    @Override
    public DTOResolutionDetails findByCode(int numResolution) throws Exception {
        String sql = "SELECT code, num_resolution, notification, executory, fmi, act, public_writing, notary, beneficiary_name FROM resolution WHERE num_resolution = ? LIMIT 1;";

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
        }
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws Exception {
        List<DTOResolutionDetails> list = new ArrayList<>();
        String sql = "SELECT code, num_resolution, notification, executory, fmi, act, public_writing, notary, beneficiary_name FROM resolution ORDER BY code DESC LIMIT 1000;";

        try (Connection connection = DataBasePool.getConnection(); 
            PreparedStatement st = connection.prepareStatement(sql); 
            ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                DTOResolutionDetails dto = new DTOResolutionDetails();
                executeQuery(dto, rs);
                list.add(dto);
            }
        }

        return list;
    }

    private void executeQuery(DTOResolutionDetails dto, ResultSet rs) throws Exception {
        dto.setCode(rs.getInt("code"));
        dto.setResolutionNumber(rs.getLong("num_resolution"));
        dto.setNotification(rs.getDate("notification").toLocalDate());
        dto.setExecutory(rs.getDate("executory").toLocalDate());
        dto.setFmi(rs.getString("fmi"));
        dto.setAct(rs.getString("act"));
        dto.setPublicWriting(rs.getString("public_writing"));
        dto.setNotary(rs.getString("notary"));
        dto.setBeneficiaryName(rs.getString("beneficiary_name"));
    }

    @Override
    public boolean modify(DTOResolutionUpdate dto) throws Exception {
        String sql = "UPDATE resolution SET executory = ?, act = ?, public_writing = ?, notification = ?, num_resolution = ?, fmi = ?, notary = ? WHERE code = ?;";

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
            st.executeUpdate();

            return true;
        }
    }

    @Override
    public int countRecords() throws Exception {
        String sql = "SELECT COUNT(*) AS total_records FROM resolution;";

        try (Connection connection = DataBasePool.getConnection(); 
            PreparedStatement st = connection.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            if (!rs.next()) {
                return 0;
            }

            return rs.getInt("total_records");
        }
    }

}
