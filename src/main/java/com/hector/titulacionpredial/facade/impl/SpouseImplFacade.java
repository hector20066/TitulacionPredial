package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.SpouseFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOSpouseImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 *
 * @author hectoracevedo
 */
public class SpouseImplFacade implements SpouseFacade {

    private final DAOSpouse daoSpouse;

    public SpouseImplFacade() {
        this.daoSpouse = DAOSpouseImpl.getInstance();
    }

    @Override
    public void add(long id, String fullName, String expeditionLocation, String address, long phone, int beneficiaryCode) throws Exception {

    }

    @Override
    public DTOSpouse findByCode(int id) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }

}
