package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPointImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.DTOPoint;

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
        DTOPoint dto = new DTOPoint.Builder()
                .numberPoint(numberPoint)
                .northCoordinate(northCoordinate)
                .eastCoordinate(eastCoordinate)
                .distance(distance)
                .hillside(hillside)
                .propertyCode(propertyCode)
                .build();

        daoPoint.add(dto);
    }

    @Override
    public DTOPoint findByCode(int propertyCode) throws Exception {
        return daoPoint.findByCode(propertyCode);
    }

}
