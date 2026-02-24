package com.hector.titulacionpredial.exception.dao;

/**
 *
 * @author hectoracevedo
 */
public class PersistenceException extends Exception {

    public PersistenceException() {
        super("Ha ocurrido un error con el manejo de la información");
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
