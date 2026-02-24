package com.hector.titulacionpredial.exception.dao;

/**
 *
 * @author hectoracevedo
 */
public class PersistenceException extends Exception {

    public PersistenceException() {
        super("Error en la capa de persistencia.");
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
