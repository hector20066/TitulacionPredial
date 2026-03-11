package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.Role;

/**
 * Base entity to represent the system users.
 *
 * <p>
 * This class only represents the system users, and the
 * different roles they have.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class User {

    private String fullName;
    private long id;
    private String user;
    private String password;
    private Role role;

    /**
     * Empty constructor required for persistence frameworks or
     * reflection mechanisms.
     */
    public User() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role.getRole();
    }
}
