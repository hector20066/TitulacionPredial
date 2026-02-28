package com.hector.titulacionpredial.exception.validation;

/**
 * Excepción lanzada cuando uno o más campos obligatorios
 * del formulario se encuentran vacíos.
 *
 * <p>
 * Extiende {@link InvalidInputException} para especializar
 * la validación de campos requeridos.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class EmptyFieldException extends InvalidInputException {

    /**
     * Crea una excepción indicando qué campos están vacíos.
     *
     * @param fieldName nombre(s) del campo o campos vacíos
     */
    public EmptyFieldException(String fieldName) {
        super("Los campos '" + fieldName + "' no pueden estar vacíos.");
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
