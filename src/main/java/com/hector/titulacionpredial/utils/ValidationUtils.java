package com.hector.titulacionpredial.utils;

import java.util.Arrays;

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
public class ValidationUtils {

    /**
     * Check if the provided string contains only digits.
     *
     * @param value string to validate
     * @return {@code true} if the string is composed only
     * of digits, {@code false} otherwise
     */
    public static boolean isNumeric(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        return value.matches("\\d+");
    }

    public static boolean isEmptyFields(String... fields) {
        return Arrays.stream(fields).anyMatch(field -> field == null || field.isBlank());
    }

}
