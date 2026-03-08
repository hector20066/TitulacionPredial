package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 * Basic interface that defines the fundamental data access operations
 * for all entities in the system.
 *
 * <p>
 * It establishes the minimum contract that each DAO must fulfill:
 * insert a new record and search by code.
 * </p>
 *
 * @param <C> type of DTO used for record creation
 * @param <D> type of DTO returned as a result of the query
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public interface DAOBase<C, D> {

    /**
     * Insert a new record into the database.
     *
     * @param dto object with the data to be inserted
     * @throws DAOException if an error occurs during the operation
     */
    void add(C dto) throws DAOException;

    /**
     * Search for a record by its unique code.
     *
     * @param code record identifier code
     * @return DTO with the data from the found record
     * @throws DAOException if an error occurs or the record is not found
     */
    D findByCode(int code) throws DAOException;

}
