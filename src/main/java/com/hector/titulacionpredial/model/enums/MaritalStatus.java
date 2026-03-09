package com.hector.titulacionpredial.model.enums;

/**
 * List representing the civil statuses available within the
 * Land Titling system.
 *
 * <p>
 * Defines the possible civil statuses of a {@code Beneficiary},
 * which determine whether spouse information ({@code Spouse})
 * needs to be registered during the titling process.
 * </p>
 *
 * <p>
 * The statuses {@code MARRIED} and {@code COMMON_UNION} imply
 * the existence of a spouse associated with the beneficiary.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public enum MaritalStatus {

    SINGLE("Soltero"),
    MARRIED("Casado"),
    FREE_UNION("Union Libre"),
    DIVORCED("Divorciado"),
    WIDOWER("Viudo");

    /**
     * Legible value of civil status.
     */
    private final String value;

    /**
     * Civil status builder.
     *
     * @param value textual representation of civil status
     */
    MaritalStatus(String value) {
        this.value = value;
    }

    /**
     * Obtain the textual representation of the civil status.
     *
     * @return legible name of marital status
     */
    public String getValue() {
        return value;
    }

}
