package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 *
 * @author hectoracevedo
 */
public class PointPersistenceException extends PersistenceException {

    public PointPersistenceException() {
        super();
    }

    public PointPersistenceException(String message) {
        super(message);
    }

    public PointPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
