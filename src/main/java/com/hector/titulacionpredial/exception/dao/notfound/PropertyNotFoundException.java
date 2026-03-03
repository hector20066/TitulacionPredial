package com.hector.titulacionpredial.exception.dao.notfound;

import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.i18n.LanguageManager;

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

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public PropertyNotFoundException() {
        super(lang.message("property.not.found"));
    }

    /**
     * Crea una excepción indicando la cédula catastral
     * que no produjo resultados.
     *
     * @param param cédula catastral utilizada en la búsqueda
     */
    public PropertyNotFoundException(String param) {
        super(lang.message("not.found.property.find") + " '" + param + "'");
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
