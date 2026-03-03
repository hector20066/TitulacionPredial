package com.hector.titulacionpredial.exception.validation;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Excepción lanzada cuando un campo que espera un valor
 * numérico recibe una entrada no numérica.
 *
 * <p>
 * Extiende {@link InvalidInputException} para especializar
 * la validación de entradas numéricas en los formularios.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class InvalidNumberInputException extends InvalidInputException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Crea una excepción indicando qué campo requiere
     * un valor numérico.
     *
     * @param fieldName nombre del campo con valor inválido
     */
    public InvalidNumberInputException(String fieldName) {
        super(lang.message("invalid.number.message1") + " '" + fieldName + "' " + lang.message("invalid.number.message2"));
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public InvalidNumberInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
