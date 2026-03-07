package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when no spouse records are found
 * in the database.
 *
 * <p>
 * Extends {@link DataNotFoundException} to specialize
 * the handling of search errors related to the
 * {@code Spouse} entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SpouseNotFoundException extends DataNotFoundException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic message.
     */
    public SpouseNotFoundException() {
        super(lang.message("not.found.spouse"));
    }

    /**
     * Create an exception indicating the beneficiary
     * code whose spouse was not found.
     *
     * @param param beneficiary code
     */
    public SpouseNotFoundException(String param) {
        super(lang.message("not.found.spouse.beneficiary") + " '" + param + "'");
    }

}
