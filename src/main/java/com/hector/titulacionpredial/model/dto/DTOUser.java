package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) that represents basic user information.
 *
 * <p>
 * This is a base DTO used to transport user identifiers between
 * system layers without exposing the domain User entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUser {

    protected int id;

    /**
     * Empty constructor required for serialization or mapping frameworks.
     */
    public DTOUser() {

    }

    /**
     * Constructor to initialize a user with the specified ID.
     *
     * @param id the user identifier
     */
    public DTOUser(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
