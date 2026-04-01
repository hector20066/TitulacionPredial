package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * Data Transfer Object encapsulating the internationalized texts
 * for the login content panel.
 *
 * <p>
 * Provides all the localized string resources needed to display
 * the login interface, including labels, field names, and buttons.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOContentLoginText {

    private final String title;
    private final String user;
    private final String userText;
    private final String password;
    private final String access;
    private final String login;

    /**
     * Construct an instance from the builder.
     *
     * @param builder builder with configured texts
     */
    public DTOContentLoginText(Builder builder) {
        this.title = builder.title;
        this.user = builder.user;
        this.userText = builder.userText;
        this.password = builder.password;
        this.access = builder.access;
        this.login = builder.login;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public String getUserText() {
        return userText;
    }

    public String getPassword() {
        return password;
    }

    public String getAccess() {
        return access;
    }

    public String getLogin() {
        return login;
    }

    public static class Builder {
        private String title;
        private String user;
        private String userText;
        private String password;
        private String access;
        private String login;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder userText(String userText) {
            this.userText = userText;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder access(String access) {
            this.access = access;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public DTOContentLoginText build() {
            return new DTOContentLoginText(this);
        }

    }

}
