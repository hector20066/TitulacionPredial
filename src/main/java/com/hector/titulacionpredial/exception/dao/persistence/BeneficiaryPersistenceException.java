package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 *
 * @author hectoracevedo
 */
public class BeneficiaryPersistenceException extends PersistenceException {

    public BeneficiaryPersistenceException() {
        super();
    }

    public BeneficiaryPersistenceException(String message) {
        super(message);
    }

    public BeneficiaryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
