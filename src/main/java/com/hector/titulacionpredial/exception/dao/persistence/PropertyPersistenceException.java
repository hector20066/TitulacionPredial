package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 *
 * @author hectoracevedo
 */
public class PropertyPersistenceException extends PersistenceException {

    public PropertyPersistenceException(String message) {
        super(message);
    }

    public PropertyPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
