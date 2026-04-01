package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
 * Data Transfer Object (DTO) for modifying user passwords.
 *
 * <p>
 * Used to transport password modification requests from the presentation
 * layer to the persistence layer, allowing users to change their passwords
 * while maintaining security by avoiding direct entity exposure.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserModifyPasswd extends DTOUser {

    private String password;

    /**
     * Create a new empty user password modification DTO.
     */
    public DTOUserModifyPasswd() {
        super();
    }

    /**
     * Create a user password modification DTO with password and ID.
     *
     * @param password the new password
     * @param id       the user ID
     */
    public DTOUserModifyPasswd(String password, int id) {
        super(id);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
