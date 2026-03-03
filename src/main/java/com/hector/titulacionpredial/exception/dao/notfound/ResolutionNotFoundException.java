package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

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
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ResolutionNotFoundException extends DataNotFoundException {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public ResolutionNotFoundException() {
        super(lang.message("not.found.resolution"));
    }

    /**
     * Crea una excepción indicando el número de resolución
     * que no produjo resultados.
     *
     * @param param número de resolución buscado
     */
    public ResolutionNotFoundException(String param) {
        super(lang.message("not.found.resolution.find") + " '" + param + "'");
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
