package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 * Exception thrown when a persistence error occurs while
 * performing operations on the entity {@code User}.
 *
 * <p>
 * Extends {@link PersistenceException} to specialize the
 * handling of errors when writing, updating, or deleting
 * users in the database.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
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
