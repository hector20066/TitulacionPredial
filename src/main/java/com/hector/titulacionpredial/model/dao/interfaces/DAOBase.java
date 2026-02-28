package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Interfaz base que define las operaciones fundamentales de acceso
 * a datos para todas las entidades del sistema.
 *
 * <p>
 * Establece el contrato mínimo que debe cumplir cada DAO:
 * insertar un nuevo registro y buscar por código.
 * </p>
 *
 * @param <C> tipo del DTO utilizado para la creación del registro
 * @param <D> tipo del DTO devuelto como resultado de la consulta
 * @author Hector Acevedo
 * @since 1.0
 */
public interface DAOBase<C, D> {

    /**
     * Inserta un nuevo registro en la base de datos.
     *
     * @param dto objeto con los datos a insertar
     * @throws DAOException si ocurre un error en la operación
     */
    void add(C dto) throws DAOException;

    /**
     * Busca un registro por su código único.
     *
     * @param code código identificador del registro
     * @return DTO con los datos del registro encontrado
     * @throws DAOException si ocurre un error o no se encuentra el registro
     */
    D findByCode(int code) throws DAOException;

}
