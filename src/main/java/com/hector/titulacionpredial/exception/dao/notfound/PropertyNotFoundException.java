package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when no property records are found in the database.
 *
 * <p>
 * Extends {@link DataNotFoundException} to specialize the handling
 * of search errors related to the {@code Property} entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class PropertyNotFoundException extends DataNotFoundException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic message.
     */
    public PropertyNotFoundException() {
        super(lang.message("property.not.found"));
    }

    /**
     * Create an exception indicating the cadastral certificate
     * that did not produce results.
     *
     * @param param cadastral certificate used in the search
     */
    public PropertyNotFoundException(String param) {
        super(lang.message("not.found.property.find") + " '" + param + "'");
    }

}
