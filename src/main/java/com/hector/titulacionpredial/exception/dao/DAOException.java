package com.hector.titulacionpredial.exception.dao;

/**
 *
 * @author hectoracevedo
 */
public class DAOException extends Exception {

    public DAOException() {
        super("Ha ocurrido un error en la capa de persistencia del sistema");
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
