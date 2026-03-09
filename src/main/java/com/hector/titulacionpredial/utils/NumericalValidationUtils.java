package com.hector.titulacionpredial.utils;

/**
 * Utility class for numeric validations.
 *
 * <p>
 * It provides methods to verify that a string contains only
 * numeric digits.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class NumericalValidationUtils {

    /**
     * Check if the provided string contains only digits.
     *
     * @param value string to validate
     * @return {@code true} if the string is composed only
     *         of digits, {@code false} otherwise
     */
    public static boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

}
