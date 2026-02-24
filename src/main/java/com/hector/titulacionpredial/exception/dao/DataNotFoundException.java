package com.hector.titulacionpredial.exception.dao;

/**
 *
 * @author hectoracevedo
 */
public class DataNotFoundException extends DAOException {

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
