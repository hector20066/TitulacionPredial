package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.SpouseFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOSpouseImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 * Implementation of the {@link SpouseFacade} facade for
 * spouse management.
 *
 * <p>
 * Build the necessary DATA from the received parameters and
 * delegate the operations to the DAO {@link DAOSpouseImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SpouseFacade
 * @see DAOSpouseImpl
 * @since 1.0
 */
public class SpouseImplFacade implements SpouseFacade {

    private final DAOSpouse daoSpouse;

    /**
     * Create a new instance by obtaining the spouse DAO
     * through your Singleton.
     */
    public SpouseImplFacade() {
        this.daoSpouse = DAOSpouseImpl.getInstance();
    }

    @Override
    /**     * add.     * @param id the id     * @param fullName the full name     * @param expeditionLocation the expedition location     * @param phone the phone     * @param beneficiaryCode the beneficiary code     */
    public void add(long id, String fullName, String expeditionLocation, long phone, int beneficiaryCode) throws DAOException {
        DTOSpouse dto = new DTOSpouse.Builder()
                .id(id)
                .fullName(fullName)
                .expeditionLocation(expeditionLocation)
                .phone(phone)
                .beneficiaryCode(beneficiaryCode)
                .build();

        daoSpouse.add(dto);
    }

    @Override
    /**     * find by code.     * @param id the id     * @return the find by code     */
    public DTOSpouse findByCode(int id) throws DAOException {
        return daoSpouse.findByCode(id);
    }

    @Override
    /**     * delete.     * @param id the id     */
    public void delete(int id) throws DAOException {
        daoSpouse.delete(id);
    }

}
