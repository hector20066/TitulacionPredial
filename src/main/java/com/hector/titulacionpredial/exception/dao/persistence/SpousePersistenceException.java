package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 * Exception thrown when a persistence error occurs while
 * performing operations on the entity {@code Spouse}.
 *
 * <p>
 * Extends {@link PersistenceException} to specialize the
 * handling of errors when writing, updating, or deleting
 * spouses in the database.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SpousePersistenceException extends PersistenceException {

    /**
     * Create an exception with a descriptive message.
     *
     * @param message description of the persistence error
     */
    public SpousePersistenceException(String message) {
        super(message);
    }

    /**
     * Create an exception with a descriptive message and
     * the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public SpousePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
