package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Excepción lanzada cuando el valor ingresado en un campo
 * supera la longitud máxima permitida.
 *
 * <p>
 * Extiende {@link InvalidInputException} para especializar
 * la validación de longitud máxima de caracteres.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class MaxLengthExceededException extends InvalidInputException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Crea una excepción indicando qué campo superó la longitud
     * máxima y cuál es ese límite.
     *
     * @param fieldName    nombre del campo que excedió la longitud
     * @param maximumValue cantidad máxima de caracteres permitidos
     */
    public MaxLengthExceededException(String fieldName, String maximumValue) {
        super(lang.message("max.length.message1") + " '" + fieldName + "' " + lang.message("max.length.message2") + " " + maximumValue + " " + lang.message("max.length.message3"));
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public MaxLengthExceededException(String message, Throwable cause) {
        super(message, cause);
    }

}
