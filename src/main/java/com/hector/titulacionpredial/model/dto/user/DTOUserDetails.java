package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
 * Data Transfer Object (DTO) that represents detailed user information.
 *
 * <p>
 * Used to transport user details from the persistence layer to the
 * presentation layer for display purposes, avoiding direct exposure
 * of the domain User entity.
 * </p>
 *
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
