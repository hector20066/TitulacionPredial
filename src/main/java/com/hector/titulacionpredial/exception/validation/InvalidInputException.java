package com.hector.titulacionpredial.exception.validation;

/**
 * Excepción base para errores de validación de entrada
 * en los formularios de la aplicación.
 *
 * <p>
 * Representa un error genérico de campo inválido.
 * Las subclases especializan el tipo de validación fallida:
 * </p>
 * <ul>
 *   <li>{@link EmptyFieldException} – campos vacíos</li>
 *   <li>{@link InvalidNumberInputException} – valor no numérico</li>
 *   <li>{@link MaxLengthExceededException} – longitud máxima excedida</li>
 * </ul>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class InvalidInputException extends Exception {

    /**
     * Crea una excepción con el mensaje genérico
     * «Campo invalido».
     */
    public InvalidInputException() {
        super("Campo invalido");
    }

    /**
     * Crea una excepción con un mensaje personalizado.
     *
     * @param message descripción del error de validación
     */
    public InvalidInputException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
