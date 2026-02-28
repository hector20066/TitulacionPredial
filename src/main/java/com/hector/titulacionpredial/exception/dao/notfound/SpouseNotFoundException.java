package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 * Excepción lanzada cuando no se encuentran registros de
 * cónyuges en la base de datos.
 *
 * <p>
 * Extiende {@link DataNotFoundException} para especializar
 * el manejo de errores de búsqueda relacionados con la
 * entidad {@code Spouse}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SpouseNotFoundException extends DataNotFoundException {

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public SpouseNotFoundException() {
        super("No se han encontrado registros de cónyuges");
    }

    /**
     * Crea una excepción indicando el código de beneficiario
     * cuyo cónyuge no fue encontrado.
     *
     * @param param código del beneficiario
     */
    public SpouseNotFoundException(String param) {
        super("No se han encontrado registros para el Beneficiario con código '" + param + "'");
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public SpouseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
