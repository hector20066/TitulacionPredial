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
public interface DAOBeneficiary extends DAOBase<DTOBeneficiaryCreate, DTOBeneficiaryDetails>,
        DAOListable<DTOBeneficiaryDetails>,
        DAOModifiable<DTOBeneficiaryUpdate>,
        DAORemovable,
        DAOCountable {

    DTOBeneficiaryDetails findById(long id) throws Exception;
    DTOBeneficiaryDetails findByName(String name) throws Exception;
    List<DTOBeneficiaryDetails> findAllByMunicipality(String municipality) throws Exception;
    DTOBeneficiaryDetails findAllData(int code) throws Exception;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception;

}
