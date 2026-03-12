package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOUser;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;

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
    public boolean verifyCredentials(String user, String plainPassword) throws DAOException {
        return false;
    }

    @Override
    public boolean modifyPassword(DTOUserModifyPasswd dto) throws DAOException {
        return false;
    }

    @Override
    public void add(DTOUserCreate dto) throws DAOException {

    }

    @Override
    public DTOUserDetails findByCode(int code) throws DAOException {
        return null;
    }

    @Override
    public List<DTOUserDetails> findByAll() throws DAOException {
        return List.of();
    }

    @Override
    public void delete(int code) throws DAOException {

    }

}
