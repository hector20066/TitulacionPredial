package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.beneficiary.*;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBeneficiary extends DAOBase<DTOBeneficiaryCreate, DTOBeneficiarySimpleDetails>,
        DAOListable<DTOBeneficiarySimpleDetails>,
        DAOModifiable<DTOBeneficiaryUpdate>,
        DAORemovable,
        DAOCountable {

    DTOBeneficiarySimpleDetails findById(long id) throws Exception;
    DTOBeneficiarySimpleDetails findByName(String name) throws Exception;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws Exception;
    DTOBeneficiaryDetails findAllData(int code) throws Exception;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception;

}
