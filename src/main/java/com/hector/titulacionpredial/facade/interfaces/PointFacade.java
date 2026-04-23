package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.PointImplFacade;
import com.hector.titulacionpredial.model.dto.DTOPoint;

import java.util.Set;

/**
 * Facade that defines the high-level operations for the management
 * of geographic points (coordinates) in the system.
 *
 * <p>
 * Simplifies the construction of {@link DTOPoint} and encapsulates
 * the calls to the corresponding DAO.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see PointImplFacade
 * @since 1.0
 */
public interface PointFacade {

    /**
     * Register a new geographic point associated with a property.
     *
     * @param numberPoint     point number
     * @param northCoordinate north coordinate
     * @param eastCoordinate  east coordinate
     * @param distance        distance
     * @param hillside        hillside
     * @param propertyCode    associated property code
     * @throws DAOException if an error occurs during the operation
     */
    void add(int numberPoint, String northCoordinate, String eastCoordinate, Double distance, String hillside,
             int propertyCode) throws DAOException;

    /**
     * Find the geographical points of a property.
     *
     * @param propertyCode property code
     * @return DTO with the data of the point found
     * @throws DAOException if an error occurs or it is not found
     */
    DTOPoint findByCode(int propertyCode) throws DAOException;

    Set<Integer> existingPointNumber(int propertyCode) throws DAOException;

}
