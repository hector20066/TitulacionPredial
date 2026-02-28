package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Interfaz funcional que define la capacidad de modificar
 * un registro existente en la base de datos.
 *
 * <p>
 * Los DAOs que implementen esta interfaz permitirán
 * actualizar los datos de un registro ya almacenado.
 * </p>
 *
 * @param <T> tipo del DTO con los datos a actualizar
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface IModifiable<T> {

    /**
     * Modifica un registro existente con los datos proporcionados.
     *
     * @param dto objeto con los datos actualizados
     * @return {@code true} si la modificación fue exitosa
     * @throws DAOException si ocurre un error en la operación
     */
    boolean modify(T dto) throws DAOException;

}
