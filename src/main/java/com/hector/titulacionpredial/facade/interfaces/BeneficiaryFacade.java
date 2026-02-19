package com.hector.titulacionpredial.facade.interfaces;

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
public interface BeneficiaryFacade {

    void add(long id, String fullName, Department department, Municipalities municipality, String address, long cadastralReference, MaritalStatus maritalStatus, String affectation, long phone, String crossing, String publication, String neighborhood, String expeditionLocation, int propertyCode) throws Exception;
    DTOBeneficiarySimpleDetails findByCode(int code) throws Exception;
    DTOBeneficiarySimpleDetails findById(long id) throws Exception;
    DTOBeneficiaryDetails findByName(String fullName) throws Exception;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws Exception;
    List<DTOBeneficiarySimpleDetails> findByAll() throws Exception;
    DTOBeneficiaryDetails findAllData(int code) throws Exception;
    boolean modify(String department, String municipality, String address, String maritalStatus, String affectation, long phone, String crossing, String publication, String neighborhood, int code) throws Exception;
    boolean modifyProperty(int code, int propertyCode) throws Exception;
    void delete(int code) throws Exception;
    int countRecords() throws Exception;
}
