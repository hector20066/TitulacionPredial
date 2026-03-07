package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when no resolution records are found
 * in the database.
 *
 * <p>
 * Extends {@link DataNotFoundException} to specialize the
 * handling of search errors related to the {@code Resolution}
 * entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ResolutionNotFoundException extends DataNotFoundException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic message.
     */
    public ResolutionNotFoundException() {
        super(lang.message("not.found.resolution"));
    }

    /**
     * Create an exception indicating the resolution
     * number that did not produce results.
     *
     * @param param resolution number sought
     */
    public ResolutionNotFoundException(String param) {
        super(lang.message("not.found.resolution.find") + " '" + param + "'");
    }

}
