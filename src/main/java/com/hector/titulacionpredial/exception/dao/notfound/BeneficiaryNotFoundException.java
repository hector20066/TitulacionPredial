package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 * Excepción lanzada cuando no se encuentran registros de
 * beneficiarios en la base de datos.
 *
 * <p>
 * Extiende {@link DataNotFoundException} para especializar
 * el manejo de errores de búsqueda relacionados con la
 * entidad {@code Beneficiary}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class BeneficiaryNotFoundException extends DataNotFoundException {

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public BeneficiaryNotFoundException() {
        super("No se han encontrado registros de Beneficiarios");
    }

    /**
     * Crea una excepción indicando el parámetro de búsqueda
     * que no produjo resultados.
     *
     * @param param parámetro de búsqueda utilizado
     */
    public BeneficiaryNotFoundException(String param) {
        super("No se han encontrado registros para el parámetro de búsqueda '" + param + "'");
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public BeneficiaryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
