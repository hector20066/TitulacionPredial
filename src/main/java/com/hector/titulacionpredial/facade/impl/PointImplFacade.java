package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPointImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

/**
 *
 * @author hectoracevedo
 */
public class PointImplFacade implements PointFacade {

    private final DAOPoint daoPoint;

    public PointImplFacade() {
        this.daoPoint = DAOPointImpl.getInstance();
    }

    @Override
    public void add(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside, int propertyCode) throws Exception {

    }

    @Override
    public DTOPointDetails findById(int numberPoint) throws Exception {
        return null;
    }

    @Override
    public DTOPointDetails findByCode(int propertyCode) throws Exception {
        return null;
    }

}
