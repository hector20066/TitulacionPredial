package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.beneficiary.*;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBeneficiary extends DAOBase<DTOBeneficiaryCreate, DTOBeneficiarySimpleDetails>,
        IListable<DTOBeneficiarySimpleDetails>,
        IModifiable<DTOBeneficiaryUpdate>,
        IRemovable,
        ICountable {

    DTOBeneficiarySimpleDetails findById(long id) throws Exception;
    DTOBeneficiarySimpleDetails findByName(String name) throws Exception;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws Exception;
    DTOBeneficiaryDetails findAllData(int code) throws Exception;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception;
    int getLastCode() throws Exception;
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws Exception;
    int countBeneficiariesWithProperty() throws Exception;
    int percentBeneficiariesWithProperty() throws Exception;

}
