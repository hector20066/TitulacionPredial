package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Interfaz funcional que define la capacidad de eliminar
 * un registro de la base de datos.
 *
 * <p>
 * Los DAOs que implementen esta interfaz permitirán
 * la eliminación de registros por su código único.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface IRemovable {

    /**
     * Elimina un registro de la base de datos.
     *
     * @param code código identificador del registro a eliminar
     * @throws DAOException si ocurre un error en la operación
     */
    void delete(int code) throws DAOException;

}
