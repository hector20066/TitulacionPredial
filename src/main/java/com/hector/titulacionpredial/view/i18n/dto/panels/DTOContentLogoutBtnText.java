package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public record DTOContentLogoutBtnText(String logout) {

    public DTOContentLogoutBtnText(Builder logout) {
        this(logout.logout);
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
