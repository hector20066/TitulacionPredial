package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * Data Transfer Object (DTO) for creating new users in the system.
 *
 * <p>
 * Contains the necessary information to register a new user including
 * name, username, password, and role assignment.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserCreate extends DTOUser {

    private String name;
    private String user;
    private String password;
    private Role role;

    /**
     * Empty constructor required for serialization or mapping frameworks.
     */
    public DTOUserCreate() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOUserCreate(Builder builder) {
        super(builder.id);

        this.name = builder.name;
        this.user = builder.user;
        this.password = builder.password;
        this.role = builder.role;
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

    public static class Builder {

        private String name;
        private int id;
        private String user;
        private String password;
        private Role role;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public DTOUserCreate build() {
            return new DTOUserCreate(this);
        }

    }

}
