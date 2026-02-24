package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 *
 * @author hectoracevedo
 */
public class PropertyNotFoundException extends DataNotFoundException {

    public PropertyNotFoundException() {
        super("No se han encontrado registros de Predios");
    }

    public PropertyNotFoundException(String param) {
        super("No se han encontrado Predios asociados a la cedula catastral '" + param + "'");
    }

    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
