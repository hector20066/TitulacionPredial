package com.hector.titulacionpredial.model.enums;

/**
 *
 * @author hectoracevedo
 */
public enum MaritalStatus {

    SOLTERO("Soltero"),
    CASADO("Casado"),
    UNION_LIBRE("Union Libre"),
    DIVORCIADO("Divorciado"),
    VIUDO("Viudo");

    private final String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
