package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;

/**
 * Excepción lanzada cuando no se encuentran registros de
 * resoluciones en la base de datos.
 *
 * <p>
 * Extiende {@link DataNotFoundException} para especializar
 * el manejo de errores de búsqueda relacionados con la
 * entidad {@code Resolution}.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class ResolutionNotFoundException extends DataNotFoundException {

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public ResolutionNotFoundException() {
        super("No se han encontrado registros de Resoluciones");
    }

    /**
     * Crea una excepción indicando el número de resolución
     * que no produjo resultados.
     *
     * @param param número de resolución buscado
     */
    public ResolutionNotFoundException(String param) {
        super("No se encontraron registros de Resoluciones con el numero '" + param + "'");
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public ResolutionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
