package com.hector.titulacionpredial.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.UserNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.UserPersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOUser;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.model.security.BCryptEncryption;
import com.hector.titulacionpredial.utils.SQLRepository;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DAOUserImpl implements DAOUser {

    private static DAOUserImpl instance;
    private static final LanguageManager lang = LanguageManager.getInstance();

    private DAOUserImpl() {

    }

    public static synchronized DAOUserImpl getInstance() {
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
            st.setInt(2, dto.getId());
            st.setString(3, dto.getUser());
            st.setString(4, dto.getPassword());
            st.setString(5, String.valueOf(dto.getRole()));
            st.executeUpdate();
        } catch (SQLException e) {
            throw new UserPersistenceException(lang.message("persistence.user.register"), e);
        }
    }

    @Override
    public Role verifyCredentials(String user, String plainPassword) throws DAOException {
        String sql = SQLRepository.get("sql/user/verifyPassword.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, user);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    return Role.NONE;
                }

                String hashedPassword = rs.getString("password");

                if (BCryptEncryption.verifyPassword(plainPassword, hashedPassword)) {
                    return Role.valueOf(rs.getString("role"));
                } else {
                    return Role.NONE;
                }
            }
        } catch (SQLException e) {
            throw new UserPersistenceException(lang.message("persistence.user.error"), e);
        }
    }

    @Override
    public boolean modifyPassword(DTOUserModifyPasswd dto) throws DAOException {
        String sql = SQLRepository.get("sql/user/modifyPassword.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, dto.getPassword());
            st.setInt(2, dto.getId());

            if (st.executeUpdate() == 0) {
                throw new UserNotFoundException(String.valueOf(dto.getId()));
            }

            return true;
        } catch (SQLException e) {
            throw new UserPersistenceException(lang.message("persistence.user.error"), e);
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
                    throw new UserNotFoundException(String.valueOf(code));
                }

                DTOUserDetails dto = new DTOUserDetails();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setUser(rs.getString("user"));

                return dto;
            }
        } catch (SQLException e) {
            throw new UserPersistenceException(lang.message("persistence.user.error"), e);
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
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setUser(rs.getString("user"));

                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new UserPersistenceException(lang.message("persistence.user.error"), e);
        }
    }

    @Override
    public void delete(int code) throws DAOException {
        String sql = SQLRepository.get("sql/user/delete.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);

            if (st.executeUpdate() == 0) {
                throw new UserNotFoundException(String.valueOf(code));
            }
        } catch (SQLException e) {
            throw new UserPersistenceException(lang.message("persistence.user.error"), e);
        }
    }

}
