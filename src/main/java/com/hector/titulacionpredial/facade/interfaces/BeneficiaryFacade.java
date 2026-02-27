package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.beneficiary.*;
import com.hector.titulacionpredial.model.enums.*;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface BeneficiaryFacade extends IListable<DTOBeneficiarySimpleDetails>, IRemovable, ICountable {

    void add(long id, String fullName, Department department, Municipalities municipality, String address,
             String cadastralReference, MaritalStatus maritalStatus, String affectation, long phone, String crossing,
             String publication, String neighborhood, String expeditionLocation) throws DAOException;

    DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException;
    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;
    DTOBeneficiarySimpleDetails findByName(String fullName) throws DAOException;
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException;
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;
    List<DTOBeneficiaryCreate> findAllForExport() throws DAOException;
    List<DTOBeneficiarySimpleDetails> findAllWithoutProperty() throws DAOException;

    boolean modify(Department department, Municipalities municipality, String address, MaritalStatus maritalStatus,
                   String affectation, long phone, String crossing, String publication, String neighborhood,
                   int code) throws DAOException;

    boolean modifyProperty(int code, int propertyCode) throws DAOException;
    int getLastCode() throws DAOException;
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException;
    int countBeneficiariesWithProperty() throws DAOException;
    int percentBeneficiariesWithProperty() throws DAOException;

}
