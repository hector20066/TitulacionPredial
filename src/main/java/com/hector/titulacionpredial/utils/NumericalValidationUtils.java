package com.hector.titulacionpredial.utils;

/**
 *
 * @author hectoracevedo
 */
public class NumericalValidationUtils {

    public static boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

}
