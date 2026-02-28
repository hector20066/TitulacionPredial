package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.SpouseFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOSpouseImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 * Implementación de la fachada {@link SpouseFacade} para la
 * gestión de cónyuges.
 *
 * <p>
 * Construye los DTOs necesarios a partir de los parámetros
 * recibidos y delega las operaciones al DAO
 * {@link DAOSpouseImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SpouseFacade
 * @see DAOSpouseImpl
 * @since 1.0
 */
public class SpouseImplFacade implements SpouseFacade {

    /**
     * DAO delegado para operaciones de cónyuges.
     */
    private final DAOSpouse daoSpouse;

    /**
     * Crea una nueva instancia obteniendo el DAO
     * de cónyuges mediante su Singleton.
     */
    public SpouseImplFacade() {
        this.daoSpouse = DAOSpouseImpl.getInstance();
    }

    @Override
    public void add(long id, String fullName, String expeditionLocation, String address, long phone,
                    int beneficiaryCode) throws DAOException {
        DTOSpouse dto = new DTOSpouse.Builder()
                .id(id)
                .fullName(fullName)
                .expeditionLocation(expeditionLocation)
                .address(address)
                .phone(phone)
                .beneficiaryCode(beneficiaryCode)
                .build();

        daoSpouse.add(dto);
    }

    @Override
    public DTOSpouse findByCode(int id) throws DAOException {
        return daoSpouse.findByCode(id);
    }

    @Override
    public void delete(int id) throws DAOException {
        daoSpouse.delete(id);
    }

}
