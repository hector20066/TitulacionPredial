package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 *
 * @author hectoracevedo
 */
public class PointNotFountException extends DataNotFoundException {

    public PointNotFountException() {
        super("No se han encontrado registros de Puntos.");
    }

    public PointNotFountException(String param) {
        super("No se han encontrado registros de puntos para el Predio con código '" + param + "'");
    }

    public PointNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

}
