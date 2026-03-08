package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.SpouseImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 * Facade that defines the high-level operations for managing
 * spouses in the system.
 *
 * <p>
 * Extends {@link IRemovable} to allow deletion of spouse records.
 * Simplifies the construction of {@link DTOSpouse} and encapsulates
 * DAO calls.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SpouseImplFacade
 * @since 1.0
 */
public interface SpouseFacade extends IRemovable {

    /**
     * Register a new spouse associated with a beneficiary.
     *
     * @param id                 spouse's ID number
     * @param fullName           full name
     * @param expeditionLocation place of issue of the document
     * @param address            address
     * @param phone              phone number
     * @param beneficiaryCode    associated beneficiary code
     * @throws DAOException if an error occurs during the operation
     */
    void add(long id, String fullName, String expeditionLocation, String address, long phone,
             int beneficiaryCode) throws DAOException;

    /**
     * Search for a spouse by the beneficiary code.
     *
     * @param id associated beneficiary code
     * @return DTO with spouse's details
     * @throws DAOException if an error occurs or it is not found
     */
    DTOSpouse findByCode(int id) throws DAOException;

}
