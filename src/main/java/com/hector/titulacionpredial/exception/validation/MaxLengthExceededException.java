package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when the value entered in a field
 * exceeds the maximum allowed length.
 *
 * <p>
 * Extends {@link InvalidInputException} to specialize
 * maximum character length validation.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class MaxLengthExceededException extends InvalidInputException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception indicating which field exceeded
     * the maximum length and what that limit is.
     *
     * @param fieldName    name of the field that exceeded the length
     * @param maximumValue maximum number of characters allowed
     */
    public MaxLengthExceededException(String fieldName, String maximumValue) {
        super(lang.message("max.length.message1") + " '" + fieldName + "' " + lang.message("max.length.message2")
                + " " + maximumValue + " " + lang.message("max.length.message3"));
    }

    /**
     * Create an exception with a custom message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public MaxLengthExceededException(String message, Throwable cause) {
        super(message, cause);
    }

}
