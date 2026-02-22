package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.*;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface BeneficiaryFacade extends IListable<DTOBeneficiarySimpleDetails>, IRemovable, ICountable {

    void add(long id, String fullName, Department department, Municipalities municipality, String address, long cadastralReference, MaritalStatus maritalStatus, String affectation, long phone, String crossing, String publication, String neighborhood, String expeditionLocation) throws Exception;
    DTOBeneficiarySimpleDetails findByCode(int code) throws Exception;
    DTOBeneficiarySimpleDetails findById(long id) throws Exception;
    DTOBeneficiarySimpleDetails findByName(String fullName) throws Exception;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws Exception;
    DTOBeneficiaryDetails findAllData(int code) throws Exception;
    boolean modify(Department department, Municipalities municipality, String address, MaritalStatus maritalStatus, String affectation, long phone, String crossing, String publication, String neighborhood, int code) throws Exception;
    boolean modifyProperty(int code, int propertyCode) throws Exception;
    int getLastCode() throws Exception;
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws Exception;

}
