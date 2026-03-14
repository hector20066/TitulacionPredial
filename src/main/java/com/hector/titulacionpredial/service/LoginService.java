package com.hector.titulacionpredial.service;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class LoginService {

    private static LoginService instance;
    private final UsersFacade daoUser;

    private LoginService() {
        this.daoUser = new UsersImplFacade();
    }

    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }

        return instance;
    }

    public Role verifyCredentials(String user, String plainPassword) throws DAOException {
        return daoUser.verifyCredentials(user, plainPassword);
    }

}
