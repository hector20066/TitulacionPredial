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

    /**     * login service.     * @return the login service     */
    private LoginService() {
        this.daoUser = new UsersImplFacade();
    }

    /**     * get instance.     * @return the get instance     */
    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }

        return instance;
    }

    /**
     * Verify user credentials and return their role.
     *
     * @param user          the username to authenticate
     * @param plainPassword the plaintext password to verify
     * @return the user's role if authentication succeeds
     * @throws DAOException if an error occurs during verification
     */
    public Role verifyCredentials(String user, String plainPassword) throws DAOException {
        return daoUser.verifyCredentials(user, plainPassword);
    }

}
