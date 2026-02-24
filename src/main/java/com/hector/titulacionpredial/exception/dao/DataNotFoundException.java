package com.hector.titulacionpredial.exception.dao;

/**
 *
 * @author hectoracevedo
 */
public class DataNotFoundException extends Exception {

    public DataNotFoundException() {
        super("No se han encontrado registros");
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
