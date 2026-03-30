package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserCreate extends DTOUser {

    private String name;
    private String user;
    private String password;
    private Role role;

    /**     * dto user create.     * @return the dto user create     */
    public DTOUserCreate() {
        super();
    }

    /**     * dto user create.     * @param builder the builder     * @return the dto user create     */
    public DTOUserCreate(Builder builder) {
        super(builder.id);

        this.name = builder.name;
        this.user = builder.user;
        this.password = builder.password;
        this.role = builder.role;
    }

    /**     * get name.     * @return the get name     */
    public String getName() {
        return name;
    }

    /**     * set name.     * @param name the name     */
    public void setName(String name) {
        this.name = name;
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

    public static class Builder {

        private String name;
        private int id;
        private String user;
        private String password;
        private Role role;

    /**     * name.     * @param name the name     * @return the name     */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

    /**     * id.     * @param id the id     * @return the id     */
        public Builder id(int id) {
            this.id = id;
            return this;
        }

    /**     * user.     * @param user the user     * @return the user     */
        public Builder user(String user) {
            this.user = user;
            return this;
        }

    /**     * password.     * @param password the password     * @return the password     */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

    /**     * role.     * @param role the role     * @return the role     */
        public Builder role(Role role) {
            this.role = role;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOUserCreate build() {
            return new DTOUserCreate(this);
        }

    }

}
