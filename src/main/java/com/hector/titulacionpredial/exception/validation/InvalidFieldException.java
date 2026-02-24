package com.hector.titulacionpredial.exception.validation;

/**
 *
 * @author hectoracevedo
 */
public class InvalidFieldException extends Exception {

    public InvalidFieldException() {
        super("Campo invalido");
    }

    public InvalidFieldException(String message) {
        super(message);
    }

    public InvalidFieldException(String message, Throwable cause) {
        super(message, cause);
    }

}
