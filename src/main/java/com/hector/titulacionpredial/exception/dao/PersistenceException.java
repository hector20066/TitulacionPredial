package com.hector.titulacionpredial.exception.dao;

/**
 * Excepción que indica un error durante una operación de
 * persistencia (inserción, actualización o eliminación)
 * en la base de datos.
 *
 * <p>
 * Extiende {@link DAOException} y sirve como clase base para
 * excepciones específicas de persistencia por entidad como
 * {@link com.hector.titulacionpredial.exception.dao.persistence.BeneficiaryPersistenceException},
 * {@link com.hector.titulacionpredial.exception.dao.persistence.PropertyPersistenceException}, etc.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class PersistenceException extends DAOException {

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public PersistenceException() {
        super("Error en la capa de persistencia.");
    }

    /**
     * Crea una excepción con un mensaje personalizado.
     *
     * @param message descripción del error
     */
    public PersistenceException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
