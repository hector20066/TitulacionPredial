package com.hector.titulacionpredial.i18n;

/**
 * List representing the languages available within
 * the application.
 *
 * <p>
 * Define the available languages that the application
 * will have, which will be used to select the language.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public enum AppLanguage {

    ES("es"),
    EN("en");

    private final String code;

    /**
     * Constructor used to indicate the language code.
     *
     * @param code language identifier
     */
    AppLanguage(String code) {
        this.code = code;
    }

    /**
     * Get the language code.
     *
     * @return language identifier
     */
    public String getCode() {
        return code;
    }

}
