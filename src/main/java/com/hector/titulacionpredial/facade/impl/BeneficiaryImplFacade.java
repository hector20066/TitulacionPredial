package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOBeneficiaryImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.*;
import com.hector.titulacionpredial.model.enums.*;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class BeneficiaryImplFacade implements BeneficiaryFacade {

    private final DAOBeneficiary daoBeneficiary;

    public BeneficiaryImplFacade() {
        this.daoBeneficiary = DAOBeneficiaryImpl.getInstance();
    }

    @Override
    public void add(long id, String fullName, Department department, Municipalities municipality, String address,
                    long cadastralReference, MaritalStatus maritalStatus, String affectation, long phone, String crossing,
                    String publication, String neighborhood, String expeditionLocation) throws DAOException {

        DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate.Builder()
                .id(id)
                .fullName(fullName)
                .department(department)
                .municipality(municipality)
                .address(address)
                .cadastralReference(cadastralReference)
                .maritalStatus(maritalStatus)
                .affectation(affectation)
                .phone(phone)
                .crossing(crossing)
                .publication(publication)
                .neighborhood(neighborhood)
                .expeditionLocation(expeditionLocation)
                .build();

        daoBeneficiary.add(dto);
    }

    @Override
    public DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException {
        return daoBeneficiary.findByCode(code);
    }

    @Override
    public DTOBeneficiarySimpleDetails findById(long id) throws DAOException {
        return daoBeneficiary.findById(id);
    }

    @Override
    public DTOBeneficiarySimpleDetails findByName(String fullName) throws DAOException {
        return daoBeneficiary.findByName(fullName);
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException {
        return daoBeneficiary.findAllByMunicipality(municipality);
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findByAll() throws DAOException {
        return daoBeneficiary.findByAll();
    }

    @Override
    public DTOBeneficiaryDetails findAllData(int code) throws DAOException {
        return daoBeneficiary.findAllData(code);
    }

    @Override
    public boolean modify(Department department, Municipalities municipality, String address, MaritalStatus maritalStatus,
                          String affectation, long phone, String crossing, String publication, String neighborhood, int code) throws DAOException {

        DTOBeneficiaryUpdate dto = new DTOBeneficiaryUpdate.Builder()
                .department(department)
                .municipality(municipality)
                .address(address)
                .maritalStatus(maritalStatus)
                .affectation(affectation)
                .phone(phone)
                .crossing(crossing)
                .publication(publication)
                .neighborhood(neighborhood)
                .code(code)
                .build();

        return daoBeneficiary.modify(dto);
    }

    @Override
    public boolean modifyProperty(int code, int propertyCode) throws DAOException {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate();
        dto.setBeneficiaryCode(code);
        dto.setPropertyCode(propertyCode);

        return daoBeneficiary.modifyProperty(dto);
    }

    @Override
    public void delete(int code) throws DAOException {
        daoBeneficiary.delete(code);
    }

    @Override
    public int countRecords() throws DAOException {
        return daoBeneficiary.countRecords();
    }

    @Override
    public int getLastCode() throws DAOException {
        return daoBeneficiary.getLastCode();
    }

    @Override
    public List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException {
        return daoBeneficiary.countBeneficiariesLastMonths(months);
    }

    @Override
    public int countBeneficiariesWithProperty() throws DAOException {
        return daoBeneficiary.countBeneficiariesWithProperty();
    }

    @Override
    public int percentBeneficiariesWithProperty() throws DAOException {
        return daoBeneficiary.percentBeneficiariesWithProperty();
    }

}
