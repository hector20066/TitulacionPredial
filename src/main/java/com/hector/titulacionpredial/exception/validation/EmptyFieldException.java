package com.hector.titulacionpredial.exception.validation;

/**
 *
 * @author hectoracevedo
 */
public class EmptyFieldException extends InvalidFieldException {

    public EmptyFieldException(String fieldName) {
        super("El campo '" + fieldName + "' no puede estar vacío.");
    }

    public EmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }

}
