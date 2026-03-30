package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * Facade that defines the high-level operations for user account
 * management in the system.
 *
 * <p>
 * It extends {@link IListable} and {@link IRemovable} to offer user
 * listing and deletion operations, in addition to account creation,
 * authentication, and password management.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see com.hector.titulacionpredial.facade.impl.UsersImplFacade
 * @since 1.0
 */
public interface UsersFacade extends IListable<DTOUserDetails>, IRemovable {

    /**
     * Create a new user account in the system.
     *
     * @param name          user's full name
     * @param id            unique identifier number
     * @param user          username for login
     * @param plainPassword plaintext password (will be encrypted)
     * @param role          user's role in the system
     * @throws com.hector.titulacionpredial.exception.dao.DAOException if an error occurs during the operation
     */
    void add(String name, int id, String user, String plainPassword, Role role) throws com.hector.titulacionpredial.exception.dao.DAOException;

    /**
     * Search for a user account by their unique code.
     *
     * @param code the user's unique identifier
     * @return DTO with user account information
     * @throws com.hector.titulacionpredial.exception.dao.DAOException if an error occurs or the user is not found
     */
    DTOUserDetails findByCode(int code) throws com.hector.titulacionpredial.exception.dao.DAOException;
    /**
     * Verify user credentials and return their role.
     *
     * @param user          the username to authenticate
     * @param plainPassword the plaintext password to verify
     * @return the {@link Role} associated with the verified user
     * @throws com.hector.titulacionpredial.exception.dao.DAOException if authentication fails or an error occurs
     */
    Role verifyCredentials(String user, String plainPassword) throws com.hector.titulacionpredial.exception.dao.DAOException;
    /**
     * Update a user's password.
     *
     * @param id            the unique identifier of the user
     * @param plainPassword the new plaintext password (will be encrypted)
     * @return true if the password was successfully updated, false otherwise
     * @throws com.hector.titulacionpredial.exception.dao.DAOException if an error occurs during the operation
     */
    boolean modifyPassword(int id, String plainPassword) throws com.hector.titulacionpredial.exception.dao.DAOException;

}
