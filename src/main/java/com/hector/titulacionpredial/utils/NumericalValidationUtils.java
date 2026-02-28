package com.hector.titulacionpredial.utils;

/**
 * Clase utilitaria para validaciones numéricas.
 *
 * <p>
 * Proporciona métodos para verificar que una cadena
 * contiene únicamente dígitos numéricos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class NumericalValidationUtils {

    /**
     * Verifica si la cadena proporcionada contiene únicamente dígitos.
     *
     * @param value cadena a validar
     * @return {@code true} si la cadena está compuesta solo por dígitos,
     * {@code false} en caso contrario
     */
    public static boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

}
