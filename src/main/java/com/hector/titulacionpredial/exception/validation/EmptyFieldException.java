package com.hector.titulacionpredial.exception.validation;

/**
 *
 * @author hectoracevedo
 */
public class EmptyFieldException extends InvalidInputException {

    public EmptyFieldException(String fieldName) {
        super("Los campos '" + fieldName + "' no pueden estar vacíos.");
    }

    public EmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }

}
