package com.hector.titulacionpredial.exception.validation;

/**
 *
 * @author hectoracevedo
 */
public class MaxLengthExceededException extends InvalidFieldException {

    public MaxLengthExceededException(String fieldName, String maximumValue) {
        super("El campo '" + fieldName + "' debe tener un valor máximo de " + maximumValue + " caracteres");
    }

    public MaxLengthExceededException(String message, Throwable cause) {
        super(message, cause);
    }

}
