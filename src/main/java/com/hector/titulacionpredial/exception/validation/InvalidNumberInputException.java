package com.hector.titulacionpredial.exception.validation;

/**
 *
 * @author hectoracevedo
 */
public class InvalidNumberInputException extends InvalidFieldException {

    public InvalidNumberInputException(String fieldName) {
        super("El campo '" + fieldName + "' debe tener un valor numérico.");
    }

    public InvalidNumberInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
