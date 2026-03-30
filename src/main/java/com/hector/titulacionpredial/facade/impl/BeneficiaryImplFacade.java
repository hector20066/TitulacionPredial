package com.hector.titulacionpredial.facade.impl;

import java.util.List;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOBeneficiaryImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesCode;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Implementation of the {@link BeneficiaryFacade} facade
 * for beneficiary management.
 *
 * <p>
 * Build the necessary DATA from the received parameters and
 * delegate the operations to the DAO {@link DAOBeneficiaryImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see BeneficiaryFacade
 * @see DAOBeneficiaryImpl
 * @since 1.0
 */
public class BeneficiaryImplFacade implements BeneficiaryFacade {

    private final DAOBeneficiary daoBeneficiary;

    /**
     * Create a new instance by obtaining the beneficiary
     * DAO through your Singleton.
     */
    public BeneficiaryImplFacade() {
        this.daoBeneficiary = DAOBeneficiaryImpl.getInstance();
    }

    @Override
    public int add(String codeBeneficiary, long id, String fullName, MaritalStatus maritalStatus, String affectation,
                    long phone, String expeditionLocation, int propertyCode) throws DAOException {

        DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate.Builder()
                .id(id)
                .codeBeneficiaries(codeBeneficiary)
                .fullName(fullName)
                .maritalStatus(maritalStatus)
                .affectation(affectation)
                .phone(phone)
                .expeditionLocation(expeditionLocation)
                .propertyCode(propertyCode)
                .build();

        return daoBeneficiary.add(dto);
    }

    @Override
    /**     * find by code.     * @param code the code     * @return the find by code     */
    public DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException {
        return daoBeneficiary.findByCode(code);
    }

    @Override
    /**     * find by id.     * @param id the id     * @return the find by id     */
    public DTOBeneficiarySimpleDetails findById(long id) throws DAOException {
        return daoBeneficiary.findById(id);
    }

    @Override
    /**     * find by name.     * @param fullName the full name     * @return the find by name     */
    public DTOBeneficiarySimpleDetails findByName(String fullName) throws DAOException {
        return daoBeneficiary.findByName(fullName);
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findAllByMunicipality(Municipalities municipality) throws DAOException {
        return daoBeneficiary.findAllByMunicipality(String.valueOf(municipality));
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findByAll() throws DAOException {
        return daoBeneficiary.findByAll();
    }

    @Override
    /**     * find all data.     * @param code the code     * @return the find all data     */
    public DTOBeneficiaryDetails findAllData(int code) throws DAOException {
        return daoBeneficiary.findAllData(code);
    }

    @Override
    public List<DTOBeneficiaryDetails> findAllForExport() throws DAOException {
        return daoBeneficiary.findAllForExport();
    }

    @Override
    /**     * find by beneficiaries code.     * @param beneficiariesCode the beneficiaries code     * @return the find by beneficiaries code     */
    public DTOBeneficiariesCode findByBeneficiariesCode(String beneficiariesCode) throws DAOException {
        return daoBeneficiary.findByBeneficiariesCode(beneficiariesCode);
    }

    @Override
    public boolean modify(long id, String codeBeneficiaries, String fullName, MaritalStatus maritalStatus, String affectation,
                          long phone, String expeditionLocation, int code) throws DAOException {

        DTOBeneficiaryUpdate dto = new DTOBeneficiaryUpdate.Builder()
                .id(id)
                .maritalStatus(maritalStatus)
                .affectation(affectation)
                .phone(phone)
                .code(code)
                .codeBeneficiaries(codeBeneficiaries)
                .expeditionLocation(expeditionLocation)
                .fullName(fullName)
                .build();

        return daoBeneficiary.modify(dto);
    }

    @Override
    /**     * delete.     * @param code the code     */
    public void delete(int code) throws DAOException {
        daoBeneficiary.delete(code);
    }

    @Override
    /**     * count records.     * @return the count records     */
    public int countRecords() throws DAOException {
        return daoBeneficiary.countRecords();
    }

    @Override
    /**     * get last code.     * @return the get last code     */
    public int getLastCode() throws DAOException {
        return daoBeneficiary.getLastCode();
    }

    @Override
    public List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException {
        return daoBeneficiary.countBeneficiariesLastMonths(months);
    }

    @Override
    /**     * count beneficiaries with property.     * @return the count beneficiaries with property     */
    public int countBeneficiariesWithProperty() throws DAOException {
        return daoBeneficiary.countBeneficiariesWithProperty();
    }

    @Override
    /**     * percent beneficiaries with property.     * @return the percent beneficiaries with property     */
    public int percentBeneficiariesWithProperty() throws DAOException {
        return daoBeneficiary.percentBeneficiariesWithProperty();
    }

}
