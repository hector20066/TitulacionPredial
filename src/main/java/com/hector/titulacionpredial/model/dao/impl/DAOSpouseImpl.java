package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;

/**
 *
 * @author hectoracevedo
 */
public class DAOSpouseImpl implements DAOSpouse {

    private static DAOSpouseImpl instance;

    private DAOSpouseImpl() {

    }

    public static DAOSpouseImpl getInstance() {
        if (instance == null) {
            instance = new DAOSpouseImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOSpouse dto) throws Exception {
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
        }
    }

    @Override
    public DTOSpouse findByCode(int id) throws Exception {
        String sql = SQLRepository.get("sql/spouse/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setLong(1, id);

            try(ResultSet rs = st.executeQuery()) {
                if(!rs.next()) {
                    return null;
                }

                DTOSpouse dto = new DTOSpouse();
                executeQuery(dto, rs);
                return dto;
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = SQLRepository.get("sql/spouse/delete.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setLong(1, id);
             st.executeUpdate();
        }
    }

    private void executeQuery(DTOSpouse dto, ResultSet rs) throws Exception {
        dto.setId(rs.getLong("id"));
        dto.setFullName(rs.getString("full_name"));
        dto.setExpeditionLocation(rs.getString("expedition_location"));
        dto.setAddress(rs.getString("address"));
        dto.setPhone(rs.getLong("phone"));
        dto.setBeneficiaryCode(rs.getInt("beneficiary_code"));
    }

}
