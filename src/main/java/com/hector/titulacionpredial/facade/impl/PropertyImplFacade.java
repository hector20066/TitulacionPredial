package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPropertyImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

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
        DTOPropertyCreate dto = new DTOPropertyCreate();
        dto.setCadastralId(cadastralId);
        dto.setArea(area);

        daoProperty.add(dto);
    }

    @Override
    public DTOPropertyDetails findByCode(int code) throws Exception {
        return daoProperty.findByCode(code);
    }

    @Override
    public List<DTOPropertyDetails> findByAll() throws Exception {
        return daoProperty.findByAll();
    }

    @Override
    public void delete(int code) throws Exception {
        daoProperty.delete(code);
    }

    @Override
    public int countRecords() throws Exception {
        return daoProperty.countRecords();
    }

}
