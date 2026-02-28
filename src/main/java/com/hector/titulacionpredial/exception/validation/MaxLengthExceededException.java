package com.hector.titulacionpredial.exception.validation;

/**
 * Excepción lanzada cuando el valor ingresado en un campo
 * supera la longitud máxima permitida.
 *
 * <p>
 * Extiende {@link InvalidInputException} para especializar
 * la validación de longitud máxima de caracteres.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class MaxLengthExceededException extends InvalidInputException {

    /**
     * Crea una excepción indicando qué campo superó la longitud
     * máxima y cuál es ese límite.
     *
     * @param fieldName    nombre del campo que excedió la longitud
     * @param maximumValue cantidad máxima de caracteres permitidos
     */
    public MaxLengthExceededException(String fieldName, String maximumValue) {
        super("El campo '" + fieldName + "' debe tener un valor máximo de " + maximumValue + " caracteres");
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
