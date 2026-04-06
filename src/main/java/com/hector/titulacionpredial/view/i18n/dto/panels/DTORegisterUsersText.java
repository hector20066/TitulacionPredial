package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTORegisterUsersText {

    private final String title;
    private final String desc;
    private final String fullName;
    private final String id;
    private final String desc2;
    private final String user;
    private final String password;
    private final String rol;
    private final String createBtn;

    /**
     * to register users text.
     *
     * @param builder the builder
     */
    public DTORegisterUsersText(Builder builder) {
        this.title = builder.title;
        this.desc = builder.desc;
        this.fullName = builder.fullName;
        this.id = builder.id;
        this.desc2 = builder.desc2;
        this.user = builder.user;
        this.password = builder.password;
        this.rol = builder.rol;
        this.createBtn = builder.createBtn;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getFullName() {
        return fullName;
    }

    public String getId() {
        return id;
    }

    public String getDesc2() {
        return desc2;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getCreateBtn() {
        return createBtn;
    }

    public static class Builder {

        private String title;
        private String desc;
        private String fullName;
        private String id;
        private String desc2;
        private String user;
        private String password;
        private String rol;
        private String createBtn;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder desc2(String desc2) {
            this.desc2 = desc2;
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

        public Builder rol(String rol) {
            this.rol = rol;
            return this;
        }

        public Builder createBtn(String createBtn) {
            this.createBtn = createBtn;
            return this;
        }

        public DTORegisterUsersText build() {
            return new DTORegisterUsersText(this);
        }

    }

}
