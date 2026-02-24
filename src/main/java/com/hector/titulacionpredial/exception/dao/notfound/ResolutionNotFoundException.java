package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 *
 * @author hectoracevedo
 */
public class ResolutionNotFoundException extends DataNotFoundException {

    public ResolutionNotFoundException() {
        super("No se han encontrado registros de Resoluciones");
    }

    public ResolutionNotFoundException(String param) {
        super("No se encontraron registros de Resoluciones con el numero '" + param + "'");
    }

    public ResolutionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
