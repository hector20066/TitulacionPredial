package com.hector.titulacionpredial.model.dao.interfaces;

import java.util.List;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBeneficiary extends DAOBase<DTOBeneficiaryCreate, DTOBeneficiarySimpleDetails>,
        IListable<DTOBeneficiarySimpleDetails>,
        IModifiable<DTOBeneficiaryUpdate>,
        IRemovable,
        ICountable {

    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;
    DTOBeneficiarySimpleDetails findByName(String name) throws DAOException;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException;
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;
    List<DTOBeneficiaryCreate> findAllForExport() throws DAOException;
    List<DTOBeneficiarySimpleDetails> findAllWithoutProperty() throws DAOException;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws DAOException;
    int getLastCode() throws DAOException;
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException;
    int countBeneficiariesWithProperty() throws DAOException;
    int percentBeneficiariesWithProperty() throws DAOException;

}
