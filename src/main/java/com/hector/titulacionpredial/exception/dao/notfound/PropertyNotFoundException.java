package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 * Excepción lanzada cuando no se encuentran registros de
 * predios en la base de datos.
 *
 * <p>
 * Extiende {@link DataNotFoundException} para especializar
 * el manejo de errores de búsqueda relacionados con la
 * entidad {@code Property}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class PropertyNotFoundException extends DataNotFoundException {

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public PropertyNotFoundException() {
        super("No se han encontrado registros de Predios");
    }

    /**
     * Crea una excepción indicando la cédula catastral
     * que no produjo resultados.
     *
     * @param param cédula catastral utilizada en la búsqueda
     */
    public PropertyNotFoundException(String param) {
        super("No se han encontrado Predios asociados a la cedula catastral '" + param + "'");
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
