package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
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

    /**
     * Get the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
