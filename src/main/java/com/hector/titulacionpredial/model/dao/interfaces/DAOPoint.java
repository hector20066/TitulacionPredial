package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 * DAO interface for managing geographic points (coordinates)
 * in the database.
 *
 * <p>
 * Extends {@link DAOBase} with {@link DTOPoint} as both a
 * creation and query type, providing basic code insert and
 * search operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBase
 * @since 1.0
 */
public interface DAOPoint extends DAOBase<DTOPoint, DTOPoint> {

}
