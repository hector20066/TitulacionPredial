package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
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

    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;
    DTOBeneficiarySimpleDetails findByName(String name) throws DAOException;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException;
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws DAOException;
    int getLastCode() throws DAOException;
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException;
    int countBeneficiariesWithProperty() throws DAOException;
    int percentBeneficiariesWithProperty() throws DAOException;

}
