package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBeneficiary extends DAOBase<DTOBeneficiaryCreate, DTOBeneficiaryDetails>,
        DAOListable<DTOBeneficiaryDetails>,
        DAOModifiable<DTOBeneficiaryUpdate>,
        DAORemovable,
        DAOCountable {

    DTOBeneficiaryDetails findById(int id) throws Exception;
    DTOBeneficiaryDetails findByName(String name) throws Exception;
    DTOBeneficiaryDetails findByMunicipality(String municipality) throws Exception;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception;

}
