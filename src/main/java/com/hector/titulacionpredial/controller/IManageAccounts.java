package com.hector.titulacionpredial.controller;

import javax.swing.JPanel;

import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;

/**
 * Interface for user account management operations.
 *
 * <p>
 * Defines contract methods for modifying and deleting user accounts
 * in the system. Implementations handle the business logic for these
 * account management operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public interface IManageAccounts {

    /**
     * Modify an existing user account with updated information.
     *
     * @param account the {@link DTOUserDetails} containing updated user information
     */
    void modifyAccount(DTOUserDetails account);

    /**
     * Delete a user account from the system.
     *
     * @param id    the unique identifier of the user account to delete
     * @param panel the {@link JPanel} context for UI feedback or navigation
     */
    void deleteAccount(int id, JPanel panel);

}
