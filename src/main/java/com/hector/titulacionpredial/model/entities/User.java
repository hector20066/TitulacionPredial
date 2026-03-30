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
    private int id;
    private String user;
    private String password;
    private Role role;

    /**
     * Empty constructor required for persistence frameworks or
     * reflection mechanisms.
     */
    public User() {

    }

    /**     * get full name.     * @return the get full name     */
    public String getFullName() {
        return fullName;
    }

    /**     * set full name.     * @param fullName the full name     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**     * get id.     * @return the get id     */
    public int getId() {
        return id;
    }

    /**     * set id.     * @param id the id     */
    public void setId(int id) {
        this.id = id;
    }

    /**     * get user.     * @return the get user     */
    public String getUser() {
        return user;
    }

    /**     * set user.     * @param user the user     */
    public void setUser(String user) {
        this.user = user;
    }

    /**     * get password.     * @return the get password     */
    public String getPassword() {
        return password;
    }

    /**     * set password.     * @param password the password     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**     * get role.     * @return the get role     */
    public Role getRole() {
        return role;
    }

    /**     * set role.     * @param role the role     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Textual representation of the user.
     *
     * @return formatted description of user attributes
     */
    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role.getRole();
    }
}
