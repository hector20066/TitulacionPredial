package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 *
 * @author hectoracevedo
 */
public class BeneficiaryNotFoundException extends DataNotFoundException {

    public BeneficiaryNotFoundException() {
        super("No se han encontrado registros de Beneficiarios");
    }

    public BeneficiaryNotFoundException(String param) {
        super("No se han encontrado registros para el parámetro de búsqueda '" + param + "'");
    }

    public BeneficiaryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
