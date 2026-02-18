package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.point.DTOPointCreate;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

/**
 *
 * @author hectoracevedo
 */
public class DAOPointImpl implements DAOPoint {

    private static DAOPointImpl instance;

    private DAOPointImpl() {

    }

    public static DAOPointImpl getInstance() {
        if (instance == null) {
            instance = new DAOPointImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOPointCreate dto) throws Exception {

    }

    @Override
    public DTOPointDetails findById(int id) throws Exception {
        return null;
    }

    @Override
    public DTOPointDetails findByPropertyCode(int propertyCode) throws Exception {
        return null;
    }

}
