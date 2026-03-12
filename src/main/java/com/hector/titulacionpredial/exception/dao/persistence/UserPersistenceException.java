package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 * @author Ing. Hector Acevedo
 */
public class UserPersistenceException extends PersistenceException {

    /**
     * Create an exception with a generic message.
     */
    public UserPersistenceException() {
        super();
    }

    /**
     * Create an exception with a descriptive message.
     *
     * @param message description of the persistence error
     */
    public UserPersistenceException(String message) {
        super(message);
    }

    /**
     * Create an exception with a descriptive message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public UserPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
