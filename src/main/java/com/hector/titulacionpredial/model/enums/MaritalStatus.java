package com.hector.titulacionpredial.model.enums;

/**
 * Enumeración que representa los estados civiles disponibles
 * dentro del sistema de Titulación Predial.
 *
 * <p>
 * Define los posibles estados civiles de un {@code Beneficiary},
 * los cuales determinan si se requiere registrar información
 * del cónyuge ({@code Spouse}) durante el proceso de titulación.
 * </p>
 *
 * <p>
 * Los estados {@code CASADO} y {@code UNION_LIBRE} implican la
 * existencia de un cónyuge asociado al beneficiario.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public enum MaritalStatus {

    /**
     * Estado civil soltero.
     */
    SOLTERO("Soltero"),

    /**
     * Estado civil casado.
     */
    CASADO("Casado"),

    /**
     * Estado civil unión libre.
     */
    UNION_LIBRE("Union Libre"),

    /**
     * Estado civil divorciado.
     */
    DIVORCIADO("Divorciado"),

    /**
     * Estado civil viudo.
     */
    VIUDO("Viudo");

    /**
     * Valor legible del estado civil.
     */
    private final String value;

    /**
     * Constructor del estado civil.
     *
     * @param value representación textual del estado civil
     */
    MaritalStatus(String value) {
        this.value = value;
    }

    /**
     * Obtiene la representación textual del estado civil.
     *
     * @return nombre legible del estado civil
     */
    public String getValue() {
        return value;
    }

}
