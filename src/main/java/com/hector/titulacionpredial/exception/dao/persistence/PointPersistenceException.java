package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 * Exception thrown when a persistence error occurs while
 * performing operations on the entity {@code Point}.
 *
 * <p>
 * Extends {@link PersistenceException} to specialize the
 * handling of errors in writing or deleting geographic
 * points (coordinates) in the database.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class PointPersistenceException extends PersistenceException {

    /**
     * Create an exception with a generic message.
     */
    public PointPersistenceException() {
        super();
    }

    /**
     * Create an exception with a descriptive message.
     *
     * @param message description of the persistence error
     */
    public PointPersistenceException(String message) {
        super(message);
    }

    /**
     * Create an exception with a descriptive message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public PointPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
