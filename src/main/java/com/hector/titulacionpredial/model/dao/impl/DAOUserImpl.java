package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOUser;
import com.hector.titulacionpredial.model.dto.DTOUser;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.security.BCryptEncryption;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DAOUserImpl implements DAOUser {

    private static DAOUserImpl instance;

    private DAOUserImpl() {

    }

    public static DAOUserImpl getInstance() {
        if (instance == null) {
            instance = new DAOUserImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOUserCreate dto) throws DAOException {
        String sql = SQLRepository.get("sql/user/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, dto.getName());
            st.setLong(2, dto.getId());
            st.setString(3, dto.getUser());
            st.setString(4, dto.getPassword());
            st.setString(5, String.valueOf(dto.getRole()));
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public boolean verifyCredentials(String user, String plainPassword) throws DAOException {
        String sql = SQLRepository.get("sql/user/verifyPassword.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, user);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    throw new DAOException();
                }

                String hashedPassword = rs.getString("password");
                return BCryptEncryption.verifyPassword(plainPassword, hashedPassword);
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public boolean modifyPassword(DTOUserModifyPasswd dto) throws DAOException {
        String sql = SQLRepository.get("sql/user/modifyPassword.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, dto.getPassword());
            st.setLong(2, dto.getId());

            if (st.executeUpdate() == 0) {
                throw new DAOException();
            }

            return true;
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public DTOUserDetails findByCode(int code) throws DAOException {
        String sql = SQLRepository.get("sql/user/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, code);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    throw new DAOException();
                }

                DTOUserDetails dto = new DTOUserDetails();
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setUser(rs.getString("user"));

                return dto;
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public List<DTOUserDetails> findByAll() throws DAOException {
        String sql = SQLRepository.get("sql/user/findByAll.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            List<DTOUserDetails> list = new ArrayList<>();

            while (rs.next()) {
                DTOUserDetails dto = new DTOUserDetails();
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setUser(rs.getString("user"));

                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public void delete(int code) throws DAOException {
        String sql = SQLRepository.get("sql/user/delete.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, code);

            if (st.executeUpdate() == 0) {
                throw new DAOException();
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

}
