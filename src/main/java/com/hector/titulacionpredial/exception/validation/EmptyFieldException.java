package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when one or more required fields in
 * the form are empty.
 *
 * <p>
 * Extends {@link InvalidInputException} to specialize
 * the validation of required fields.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class EmptyFieldException extends InvalidInputException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception indicating which fields are empty.
     *
     * @param fieldName name(s) of the empty field or fields
     */
    public EmptyFieldException(String fieldName) {
        super("El campo " + " '" + fieldName + "' " + "No puede estar vacío");
    }

    /**
     * Create an exception with a custom message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public EmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }

}
