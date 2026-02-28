package com.hector.titulacionpredial.exception.dao;

/**
 * Excepción que indica que no se encontraron registros
 * en la base de datos para una consulta determinada.
 *
 * <p>
 * Extiende {@link DAOException} y sirve como clase base para
 * excepciones específicas de entidad como
 * {@link com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException},
 * {@link com.hector.titulacionpredial.exception.dao.notfound.PropertyNotFoundException}, etc.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class DataNotFoundException extends DAOException {

    /**
     * Crea una excepción con un mensaje genérico.
     */
    public DataNotFoundException() {
        super("No se han encontrado registros");
    }

    /**
     * Crea una excepción con un mensaje personalizado.
     *
     * @param message descripción del error
     */
    public DataNotFoundException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error
     * @param cause   excepción original
     */
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
