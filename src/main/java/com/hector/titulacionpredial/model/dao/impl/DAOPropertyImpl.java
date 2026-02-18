package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DAOPropertyImpl implements DAOProperty {

    private static DAOPropertyImpl instance;

    private DAOPropertyImpl() {

    }

    public static DAOPropertyImpl getInstance() {
        if (instance == null) {
            instance = new DAOPropertyImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOPropertyCreate dto) throws Exception {

    }

    @Override
    public DTOPropertyDetails findByCode(int code) throws Exception {
        return null;
    }

    @Override
    public List<DTOPropertyDetails> findByAll() throws Exception {
        return List.of();
    }

    @Override
    public void delete(int code) throws Exception {

    }

}
