package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetailsLogin;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * DAO interface for user account management operations.
 *
 * <p>
 * Defines contract methods for adding, retrieving, verifying credentials,
 * and modifying user accounts in the system. Extends {@link DAOBase},
 * {@link IListable}, and {@link IRemovable} for comprehensive data access
 * operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public interface DAOUser extends DAOBase<DTOUserCreate, DTOUserDetails>,
        IListable<DTOUserDetails>,
        IRemovable {

    /**
     * Verify user credentials and return their role.
     *
     * @param user          the username to authenticate
     * @param plainPassword the plaintext password to verify
     * @return the {@link Role} associated with the verified user
     * @throws DAOException if authentication fails or an error occurs
     */
    DTOUserDetailsLogin verifyCredentials(String user, String plainPassword) throws DAOException;

    /**
     * Update a user's password.
     *
     * @param dto the {@link DTOUserModifyPasswd} containing the user ID and new password
     * @return true if the password was successfully updated, false otherwise
     * @throws DAOException if an error occurs during the operation
     */
    boolean modifyPassword(DTOUserModifyPasswd dto) throws DAOException;

}
