package com.hector.titulacionpredial.i18n;

/**
 * Enumeracion que representa los idiomas disponibles
 * dentro de la aplicacion.
 *
 * <p>
 * Define los idiomas disponibles que tendra la aplicacion,
 * los cuales se usaran para seleccionar el idioma
 * </p>
 *
 * @author hectoracevedo
 */
public enum AppLanguage {

    ES("es"),
    EN("en");

    /**
     * Código del idioma
     */
    private final String code;

    /**
     * Constructor usado para indicar el
     * código del idioma.
     *
     * @param code identificador del idioma
     */
    AppLanguage(String code) {
        this.code = code;
    }

    /**
     * Obtiene el código del idioma.
     *
     * @return identificador del idioma
     */
    public String getCode() {
        return code;
    }

}
