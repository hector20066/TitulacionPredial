package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when no user records are found
 * in the database.
 *
 * <p>
 * Extends {@link DataNotFoundException} to specialize the
 * handling of search errors related to the entity
 * {@code User}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class UserNotFoundException extends DataNotFoundException {

    private static final LanguageManager lang = LanguageManager.getInstance();



    /**
     * Create an exception with a generic message.
     */
    public UserNotFoundException() {
        super(lang.message("not.found.user"));
    }

    /**
     * Create an exception by specifying the search
     * parameter that did not produce results.
     *
     * @param param search parameter used
     */
    public UserNotFoundException(String param) {
        super(lang.message("not.found.user.find") + " '" + param + "'");
    }

}
