package com.hector.titulacionpredial.exception.dao;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Base exception for all errors that occur in the data
 * access layer (DAO) of the system.
 *
 * <p>
 * It acts as the root of the DAO exception hierarchy,
 * allowing uniform handling of errors related to data
 * persistence and querying.
 * </p>
 *
 * <p>
 * Subclasses specialize the type of error:
 * </p>
 * <ul>
 *     <li>{@link DataNotFoundException} – when no records are found.</li>
 *     <li>{@link PersistenceException} – when a write operation fails.</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DAOException extends Exception {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic error message
     * in the persistence layer.
     */
    public DAOException() {
        super(lang.message("dao.message.error"));
    }

    /**
     * Create an exception with a custom message.
     *
     * @param message description of the error that occurred
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Create an exception with a custom message
     * and the original cause.
     *
     * @param message description of the error that occurred
     * @param cause   original exception that caused this error
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
