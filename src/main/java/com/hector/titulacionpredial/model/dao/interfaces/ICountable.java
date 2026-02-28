package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Interfaz funcional que define la capacidad de contar
 * registros en la base de datos.
 *
 * <p>
 * Los DAOs que implementen esta interfaz podrán obtener
 * el total de registros de su entidad correspondiente.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface ICountable {

    /**
     * Cuenta el número total de registros.
     *
     * @return cantidad de registros existentes
     * @throws DAOException si ocurre un error en la consulta
     */
    int countRecords() throws DAOException;

}
