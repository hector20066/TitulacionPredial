package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Base exception for input validation errors in application forms.
 *
 * <p>
 * This represents a generic invalid field error. Subclasses
 * specialize the type of validation failure:
 * </p>
 * <ul>
 *   <li>{@link EmptyFieldException} – empty fields</li>
 *   <li>{@link InvalidNumberInputException} – non-numeric value</li>
 *   <li>{@link MaxLengthExceededException} – maximum length exceeded</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class InvalidInputException extends Exception {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with the generic message
     * «Invalid field».
     */
    public InvalidInputException() {
        super(lang.message("invalid.input.message"));
    }

    /**
     * Create an exception with a custom message.
     *
     * @param message description of the validation error
     */
    public InvalidInputException(String message) {
        super(message);
    }

    /**
     * Create an exception with a custom message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
