package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

import java.util.List;

/**
 * Functional interface that defines the ability to list
 * all records of an entity.
 *
 * <p>
 * DAOs that implement this interface will be able to
 * obtain a complete list of records for their entity.
 * </p>
 *
 * @param <T> type of DTO that each record represents
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface IListable<T> {

    /**
     * It retrieves all the entity's records.
     *
     * @return List of DTOs with the data for each record
     * @throws DAOException if an error occurs in the query
     */
    List<T> findByAll() throws DAOException;

}
