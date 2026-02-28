package com.hector.titulacionpredial.exception.dao.persistence;

import com.hector.titulacionpredial.exception.dao.PersistenceException;

/**
 * Excepción lanzada cuando ocurre un error de persistencia
 * al realizar operaciones sobre la entidad {@code Spouse}.
 *
 * <p>
 * Extiende {@link PersistenceException} para especializar
 * el manejo de errores de escritura, actualización o
 * eliminación de cónyuges en la base de datos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SpousePersistenceException extends PersistenceException {

    /**
     * Crea una excepción con un mensaje descriptivo.
     *
     * @param message descripción del error de persistencia
     */
    public SpousePersistenceException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje descriptivo y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public SpousePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
