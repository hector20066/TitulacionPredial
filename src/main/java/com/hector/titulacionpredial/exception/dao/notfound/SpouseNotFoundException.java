package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 *
 * @author hectoracevedo
 */
public class SpouseNotFoundException extends DataNotFoundException {

    public SpouseNotFoundException() {
        super("No se han encontrado registros de cónyuges");
    }

    public SpouseNotFoundException(String param) {
        super("No se han encontrado registros para el Beneficiario con código '" + param + "'");
    }

    public SpouseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
