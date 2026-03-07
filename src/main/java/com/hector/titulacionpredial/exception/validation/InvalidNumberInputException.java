package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when a field that expects a numeric
 * value receives a non-numeric input.
 *
 * <p>
 * Extends {@link InvalidInputException} to specialize
 * the validation of numeric inputs in forms.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class InvalidNumberInputException extends InvalidInputException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception by specifying which field
     * requires a numeric value.
     *
     * @param fieldName name of field with invalid value
     */
    public InvalidNumberInputException(String fieldName) {
        super(lang.message("invalid.number.message1") + " '" + fieldName + "' " + lang.message("invalid.number.message2"));
    }

    /**
     * Create an exception with a custom message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public InvalidNumberInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
