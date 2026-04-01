package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOManageUsersText {

    private final String title;
    private final String subtitle;
    private final String name;
    private final String user;
    private final String modify;
    private final String delete;

    public DTOManageUsersText(Builder builder) {
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.name = builder.name;
        this.user = builder.user;
        this.modify = builder.modify;
        this.delete = builder.delete;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getModify() {
        return modify;
    }

    public String getDelete() {
        return delete;
    }

    public static class Builder {

        private String title;
        private String subtitle;
        private String name;
        private String user;
        private String modify;
        private String delete;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder modify(String modify) {
            this.modify = modify;
            return this;
        }

        public Builder delete(String delete) {
            this.delete = delete;
            return this;
        }

        public DTOManageUsersText build() {
            return new DTOManageUsersText(this);
        }

    }

}
