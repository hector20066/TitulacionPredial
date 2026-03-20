package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.util.List;

/**
 * Facade that defines the high-level operations for beneficiary
 * management in the system.
 *
 * <p>
 * It acts as an intermediary layer between the controllers and
 * the DAO, simplifying DTO construction and encapsulating data
 * access logic. It extends {@link IListable}, {@link IRemovable},
 * and {@link ICountable}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see BeneficiaryImplFacade
 * @since 1.0
 */
public interface BeneficiaryFacade extends IListable<DTOBeneficiarySimpleDetails>, IRemovable, ICountable {

    /**
     * Register a new beneficiary in the system.
     *
     * @param id                 ID number
     * @param fullName           full name
     * @param maritalStatus      marital status
     * @param affectation        type of impairment
     * @param phone              phone number
     * @param expeditionLocation place of issue of the document
     * @throws DAOException if an error occurs during the operation
     */
    int add(String codeBeneficiary, long id, String fullName, MaritalStatus maritalStatus, String affectation, long phone,
             String expeditionLocation, int propertyCode) throws DAOException;

    /**
     * Search for a beneficiary by their unique code.
     *
     * @param code beneficiary code
     * @return DTO with basic data
     * @throws DAOException if an error occurs or it is not found
     */
    DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException;

    /**
     * Search for a beneficiary by their ID number.
     *
     * @param id ID number
     * @return DTO with basic data
     * @throws DAOException if an error occurs or it is not found
     */
    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;

    /**
     * Search for a beneficiary by their full name.
     *
     * @param fullName beneficiary name
     * @return DTO with basic data
     * @throws DAOException if an error occurs or it is not found
     */
    DTOBeneficiarySimpleDetails findByName(String fullName) throws DAOException;

    /**
     * It obtains all the beneficiaries of a municipality.
     *
     * @param municipality name of the municipality
     * @return List of data with the beneficiaries' information
     * @throws DAOException if an error occurs in the query
     */
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException;

    /**
     * It obtains all the data of a beneficiary, including
     * spouse and associated property.
     *
     * @param code beneficiary code
     * @return DTO with complete data
     * @throws DAOException if an error occurs or it is not found
     */
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;

    /**
     * It obtains all beneficiaries in export format.
     *
     * @return list of complete DATA
     * @throws DAOException if an error occurs in the query
     */
    List<DTOBeneficiaryCreate> findAllForExport() throws DAOException;

    /**
     * It obtains beneficiaries without assigned property.
     *
     * @return List of beneficiary data without property
     * @throws DAOException if an error occurs in the query
     */
    List<DTOBeneficiarySimpleDetails> findAllWithoutProperty() throws DAOException;

    /**
     * Modify the details of an existing beneficiary.
     *
     * @param maritalStatus updated marital status
     * @param affectation   updated impact
     * @param phone         updated phone number
     * @param code          beneficiary code to be modified
     * @return {@code true} if the modification was successful
     * @throws DAOException if an error occurs during the operation
     */
    boolean modify(long id, String codeBeneficiaries, String fullName, MaritalStatus maritalStatus, String affectation,
                   long phone, String expeditionLocation, int code) throws DAOException;

    /**
     * Associate a property with a beneficiary.
     *
     * @param codeBeneficiaries beneficiary code
     * @param propertyCode      property code to be associated
     * @return {@code true} whether the partnership was successful
     * @throws DAOException if an error occurs during the operation
     */
    boolean modifyProperty(String codeBeneficiaries, int propertyCode) throws DAOException;

    /**
     * Get the latest registered beneficiary code.
     *
     * @return last sequential code
     * @throws DAOException if an error occurs in the query
     */
    int getLastCode() throws DAOException;

    /**
     * It obtains the monthly count of registered beneficiaries.
     *
     * @param months number of months to consult
     * @return list with the count per month
     * @throws DAOException if an error occurs in the query
     */
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException;

    /**
     * It counts the beneficiaries who have an associated property.
     *
     * @return number of beneficiaries with property
     * @throws DAOException if an error occurs in the query
     */
    int countBeneficiariesWithProperty() throws DAOException;

    /**
     * Calculate the percentage of beneficiaries with property.
     *
     * @return percentage (0–100)
     * @throws DAOException if an error occurs in the query
     */
    int percentBeneficiariesWithProperty() throws DAOException;

}
