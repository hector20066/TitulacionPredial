package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Exception thrown when no beneficiary records are found
 * in the database.
 *
 * <p>
 * Extends {@link DataNotFoundException} to specialize the
 * handling of search errors related to the entity
 * {@code Beneficiary}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class BeneficiaryNotFoundException extends DataNotFoundException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create an exception with a generic message.
     */
    public BeneficiaryNotFoundException() {
        super(lang.message("not.found.beneficiary"));
    }

    /**
     * Create an exception by specifying the search
     * parameter that did not produce results.
     *
     * @param param search parameter used
     */
    public BeneficiaryNotFoundException(String param) {
        super(lang.message("not.found.beneficiary.find") + " '" + param + "'");
    }

}
