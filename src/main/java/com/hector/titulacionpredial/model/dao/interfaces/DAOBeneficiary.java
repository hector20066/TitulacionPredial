package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBeneficiary {

    void add(DTOBeneficiaryCreate dto) throws Exception;
    DTOBeneficiaryDetails findByCode(int code) throws Exception;
    DTOBeneficiaryDetails findById(int id) throws Exception;
    DTOBeneficiaryDetails findByName(String name) throws Exception;
    DTOBeneficiaryDetails findByMunicipality(String municipality) throws Exception;
    List<DTOBeneficiaryDetails> findByAll() throws Exception;
    boolean modify(DTOBeneficiaryUpdate dto) throws Exception;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception;
    void delete(int code) throws Exception;

}
