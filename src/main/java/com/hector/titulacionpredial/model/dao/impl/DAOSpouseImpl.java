package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 *
 * @author hectoracevedo
 */
public class DAOSpouseImpl implements DAOSpouse {

    private static DAOSpouseImpl instance;

    private DAOSpouseImpl() {

    }

    public static DAOSpouseImpl getInstance() {
        if (instance == null) {
            instance = new DAOSpouseImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOSpouse dto) throws Exception {

    }

    @Override
    public DTOSpouse findByBeneficiaryCode(int code) throws Exception {
        return null;
    }

    @Override
    public void delete(int code) throws Exception {

    }

}
