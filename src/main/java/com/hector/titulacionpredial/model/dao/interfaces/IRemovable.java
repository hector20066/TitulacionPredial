package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Functional interface that defines the ability to
 * delete a record from the database.
 *
 * <p>
 * DAOs that implement this interface will allow the
 * deletion of records by their unique code.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface IRemovable {

    /**
     * Deletes a record from the database.
     *
     * @param code identifier code of the record to be deleted
     * @throws DAOException if an error occurs during the operation
     */
    void delete(int code) throws DAOException;

}
