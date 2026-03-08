package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Functional interface that defines the ability to count
 * records in the database.
 *
 * <p>
 * DAOs that implement this interface will be able to
 * obtain the total number of records for their corresponding
 * entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface ICountable {

    /**
     * Count the total number of records.
     *
     * @return number of existing records
     * @throws DAOException if an error occurs in the query
     */
    int countRecords() throws DAOException;

}
