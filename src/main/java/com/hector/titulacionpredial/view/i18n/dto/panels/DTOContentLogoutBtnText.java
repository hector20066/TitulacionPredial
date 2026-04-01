package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOContentLogoutBtnText {

    private final String logout;

    public DTOContentLogoutBtnText(Builder builder) {
        this.logout = builder.logout;
    }

    public String getLogout() {
        return logout;
    }

    public static class Builder {

        private String logout;

        public Builder logout(String logout) {
            this.logout = logout;
            return this;
        }

        public DTOContentLogoutBtnText build() {
            return new DTOContentLogoutBtnText(this);
        }

    }

}
