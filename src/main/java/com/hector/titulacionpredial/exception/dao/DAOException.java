package com.hector.titulacionpredial.exception.dao;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Excepción base para todos los errores que ocurren en la
 * capa de acceso a datos (DAO) del sistema.
 *
 * <p>
 * Actúa como raíz de la jerarquía de excepciones del DAO,
 * permitiendo un manejo uniforme de errores relacionados
 * con la persistencia y consulta de datos.
 * </p>
 *
 * <p>
 * Las subclases especializan el tipo de error:
 * </p>
 * <ul>
 *     <li>{@link DataNotFoundException} – cuando no se encuentran registros.</li>
 *     <li>{@link PersistenceException} – cuando falla una operación de escritura.</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DAOException extends Exception {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Crea una excepción con un mensaje genérico de error
     * en la capa de persistencia.
     */
    public DAOException() {
        super(lang.message("dao.message.error"));
    }

    /**
     * Crea una excepción con un mensaje personalizado.
     *
     * @param message descripción del error ocurrido
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje personalizado y la causa original.
     *
     * @param message descripción del error ocurrido
     * @param cause   excepción original que provocó este error
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
