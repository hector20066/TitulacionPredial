package com.hector.titulacionpredial.i18n;

/**
 *
 * @author hectoracevedo
 */
public enum AppLanguage {

    ES("es"),
    EN("en");

    private final String code;

    AppLanguage(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
