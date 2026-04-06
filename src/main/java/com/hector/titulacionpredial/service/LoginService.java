package com.hector.titulacionpredial.service;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetailsLogin;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class LoginService {

    private static LoginService instance;
    private final UsersFacade daoUser;

    /**
     * Private constructor to prevent instantiation (Singleton pattern).
     */
    private LoginService() {
        this.daoUser = new UsersImplFacade();
    }

    /**
     * Returns the unique instance of {@link LoginService}.
     *
     * @return the singleton instance
     */
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
    public DTOUserDetailsLogin verifyCredentials(String user, String plainPassword) throws DAOException {
        return daoUser.verifyCredentials(user, plainPassword);
    }

}
