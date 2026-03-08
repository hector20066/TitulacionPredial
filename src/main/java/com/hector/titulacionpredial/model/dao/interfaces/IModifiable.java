package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Functional interface that defines the ability to
 * modify an existing record in the database.
 *
 * <p>
 * DAOs that implement this interface will allow updating
 * the data of an already stored record.
 * </p>
 *
 * @param <T> DTO type with the data to be updated
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface IModifiable<T> {

    /**
     * Modify an existing record with the provided data.
     *
     * @param dto object with updated data
     * @return {@code true} if the modification was successful
     * @throws DAOException if an error occurs during the operation
     */
    boolean modify(T dto) throws DAOException;

}
