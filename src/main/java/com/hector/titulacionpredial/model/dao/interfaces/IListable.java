package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

import java.util.List;

/**
 * Interfaz funcional que define la capacidad de listar
 * todos los registros de una entidad.
 *
 * <p>
 * Los DAOs que implementen esta interfaz podrán obtener
 * una lista completa de registros de su entidad.
 * </p>
 *
 * @param <T> tipo del DTO que representa cada registro
 * @author Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface IListable<T> {

    /**
     * Obtiene todos los registros de la entidad.
     *
     * @return lista de DTOs con los datos de cada registro
     * @throws DAOException si ocurre un error en la consulta
     */
    List<T> findByAll() throws DAOException;

}
