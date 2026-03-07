package com.hector.titulacionpredial.exception.dao;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception indicating that no records were found in
 * the database for a given query.
 *
 * <p>
 * It extends {@link DAOException} and serves as a base class for entity-specific exceptions such as
 * {@link com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException},
 * {@link com.hector.titulacionpredial.exception.dao.notfound.PropertyNotFoundException}, etc.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DataNotFoundException extends DAOException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic message.
     */
    public DataNotFoundException() {
        super(lang.message("data.not.found"));
    }

    /**
     * Create an exception with a custom message.
     *
     * @param message error description
     */
    public DataNotFoundException(String message) {
        super(message);
    }

    /**
     * Create an exception with a custom message and the original cause.
     *
     * @param message error description
     * @param cause   original exception
     */
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
