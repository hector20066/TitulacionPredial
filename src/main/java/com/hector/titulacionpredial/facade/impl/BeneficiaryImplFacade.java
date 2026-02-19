package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOBeneficiaryImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

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
    public void add(long id, String fullName, Department department, Municipalities municipality, String address, long cadastralReference, MaritalStatus maritalStatus, String affectation, long phone, String crossing, String publication, String neighborhood, String expeditionLocation, int propertyCode) throws Exception {
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
                .propertyCode(propertyCode)
                .build();

        daoBeneficiary.add(dto);
    }


    @Override
    public DTOBeneficiarySimpleDetails findByCode(int code) throws Exception {
        return null;
    }

    @Override
    public DTOBeneficiarySimpleDetails findById(long id) throws Exception {
        return null;
    }

    @Override
    public DTOBeneficiaryDetails findByName(String fullName) throws Exception {
        return null;
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws Exception {
        return List.of();
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findByAll() throws Exception {
        return List.of();
    }

    @Override
    public DTOBeneficiaryDetails findAllData(int code) throws Exception {
        return null;
    }

    @Override
    public boolean modify(String department, String municipality, String address, String maritalStatus, String affectation, long phone, String crossing, String publication, String neighborhood, int code) throws Exception {
        return false;
    }

    @Override
    public boolean modifyProperty(int code, int propertyCode) throws Exception {
        return false;
    }

    @Override
    public void delete(int code) throws Exception {

    }

    @Override
    public int countRecords() throws Exception {
        return 0;
    }

}
