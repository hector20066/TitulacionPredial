package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

/**
 *
 * @author hectoracevedo
 */
public interface PointFacade {

    void add(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside, int propertyCode) throws Exception;
    DTOPointDetails findById(int numberPoint) throws Exception;
    DTOPointDetails findByCode(int propertyCode) throws Exception;
}
