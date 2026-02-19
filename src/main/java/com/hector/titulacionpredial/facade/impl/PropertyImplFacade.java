package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPropertyImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class PropertyImplFacade implements PropertyFacade {

    private final DAOProperty daoProperty;

    public PropertyImplFacade() {
        this.daoProperty = DAOPropertyImpl.getInstance();
    }

    @Override
    public void add(String cadastralId, Double area) throws Exception {

    }

    @Override
    public DTOPointDetails findByCode(int code) throws Exception {
        return null;
    }

    @Override
    public List<DTOPointDetails> findByAll() throws Exception {
        return List.of();
    }

    @Override
    public void delete(int code) throws Exception {

    }

    @Override
    public int countRecords() throws Exception {
        return 0;
    }

}
