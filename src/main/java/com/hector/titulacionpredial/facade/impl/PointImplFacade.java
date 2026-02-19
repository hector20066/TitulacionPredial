package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPointImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.point.DTOPointCreate;
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
        DTOPointCreate dto = new DTOPointCreate.Builder()
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
    public DTOPointDetails findById(int numberPoint) throws Exception {
        return daoPoint.findById(numberPoint);
    }

    @Override
    public DTOPointDetails findByCode(int propertyCode) throws Exception {
        return daoPoint.findByCode(propertyCode);
    }

}
