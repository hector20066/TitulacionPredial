package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.enums.Role;

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
public class DTOUserDetailsLogin {

    private String user;
    private Role role;

    public DTOUserDetailsLogin() {

    }

    public DTOUserDetailsLogin(String user, Role role) {
        this.user = user;
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
