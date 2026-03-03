package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Excepción lanzada cuando uno o más campos obligatorios
 * del formulario se encuentran vacíos.
 *
 * <p>
 * Extiende {@link InvalidInputException} para especializar
 * la validación de campos requeridos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class EmptyFieldException extends InvalidInputException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Crea una excepción indicando qué campos están vacíos.
     *
     * @param fieldName nombre(s) del campo o campos vacíos
     */
    public EmptyFieldException(String fieldName) {
        super(lang.message("empty.field.message1") + " '" + fieldName + "' " + lang.message("empty.field.message2"));
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public EmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }

}
