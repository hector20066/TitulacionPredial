package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

public class UserNotFoundException extends DataNotFoundException {

    /**
     * Create an exception with a generic message.
     */
    public UserNotFoundException() {
        super("No se han encontrado registros de User");
    }

    /**
     * Create an exception by specifying the search
     * parameter that did not produce results.
     *
     * @param param search parameter used
     */
    public UserNotFoundException(String param) {
        super("No se han encontrado registros para el parÃ¡metro de bÃºsqueda" + " '" + param + "'");
    }

}
