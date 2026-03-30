package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserDetails extends DTOUser {

    private String name;
    private String user;

    /**
     * Create a new empty user details DTO.
     */
    public DTOUserDetails() {
        super();
    }

    /**
     * Create a user details DTO with name, user, and ID.
     *
     * @param name the user's name
     * @param user the username
     * @param id   the user ID
     */
    public DTOUserDetails(String name, String user, int id) {
        super(id);
        this.name = name;
        this.user = user;
    }

    /**
     * Get the user name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the user name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the username.
     *
     * @return the username
     */
    public String getUser() {
        return user;
    }

    /**
     * Set the username.
     *
     * @param user the username to set
     */
    public void setUser(String user) {
        this.user = user;
    }

}
