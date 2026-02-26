package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 *
 * @author hectoracevedo
 */
public interface PointFacade {

    void add(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside,
             int propertyCode) throws DAOException;

    DTOPoint findByCode(int propertyCode) throws DAOException;

}
