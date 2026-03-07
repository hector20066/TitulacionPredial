package com.hector.titulacionpredial.exception.dao;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception that indicates an error during a persistence
 * operation (insertion, update, or deletion) in the database.
 *
 * <p>
 * It extends {@link DAOException} and serves as a base class for entity-specific persistence exceptions such as
 * {@link com.hector.titulacionpredial.exception.dao.persistence.BeneficiaryPersistenceException},
 * {@link com.hector.titulacionpredial.exception.dao.persistence.PropertyPersistenceException}, etc.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class PersistenceException extends DAOException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic message.
     */
    public PersistenceException() {
        super(lang.message("persistence.message"));
    }

    /**
     * Create an exception with a custom message.
     *
     * @param message error description
     */
    public PersistenceException(String message) {
        super(message);
    }

    /**
     * Create an exception with a custom message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
