package com.hector.titulacionpredial.exception.validation;

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

    /**
     * Crea una excepción indicando qué campo requiere
     * un valor numérico.
     *
     * @param fieldName nombre del campo con valor inválido
     */
    public InvalidNumberInputException(String fieldName) {
        super("El campo '" + fieldName + "' debe tener un valor numérico.");
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
