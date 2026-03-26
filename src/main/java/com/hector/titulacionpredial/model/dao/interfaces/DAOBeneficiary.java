package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.beneficiary.*;

import java.util.List;

/**
 * DAO interface for managing beneficiaries in the database.
 *
 * <p>
 * Extends the base interfaces to offer full CRUD operations,
 * listing, counting, and specialized searches on the
 * {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Specific operations include:
 * </p>
 * <ul>
 *   <li>Search by ID number, name, and municipality</li>
 *   <li>Obtaining complete data with spouse and property</li>
 *   <li>Bulk export of records</li>
 *   <li>Monthly statistics and percentages with property</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBase
 * @see IListable
 * @see IModifiable
 * @see IRemovable
 * @see ICountable
 * @since 1.0
 */
public interface DAOBeneficiary extends IListable<DTOBeneficiarySimpleDetails>,
        IModifiable<DTOBeneficiaryUpdate>,
        IRemovable,
        ICountable {

    /**
     * Insert a new record into the database.
     *
     * @param dto object with the data to be inserted
     * @throws DAOException if an error occurs during the operation
     */
    int add(DTOBeneficiaryCreate dto) throws DAOException;

    /**
     * Search for a record by its unique code.
     *
     * @param code record identifier code
     * @return DTO with the data from the found record
     * @throws DAOException if an error occurs or the record is not found
     */
    DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException;

    /**
     * Search for a beneficiary by their ID number.
     *
     * @param id beneficiary's ID number
     * @return DTO with the beneficiary's basic data
     * @throws DAOException if an error occurs or the record is not found
     */
    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;

    /**
     * Search for a beneficiary by name.
     *
     * @param name beneficiary name
     * @return DTO with the beneficiary's basic data
     * @throws DAOException if an error occurs or the record is not found
     */
    DTOBeneficiarySimpleDetails findByName(String name) throws DAOException;

    /**
     * It obtains all the beneficiaries of a specific municipality.
     *
     * @param municipality name of the municipality
     * @return List of data with the beneficiaries' information
     * @throws DAOException if an error occurs in the query
     */
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException;

    /**
     * It obtains all the data of a beneficiary, including spouse and
     * associated property.
     *
     * @param code unique beneficiary code
     * @return DTO with the beneficiary's complete details
     * @throws DAOException if an error occurs or the record is not found
     */
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;

    /**
     * It obtains all beneficiaries in export format.
     *
     * @return List of DTOs with complete data for export
     * @throws DAOException if an error occurs in the query
     */
    List<DTOBeneficiaryCreate> findAllForExport() throws DAOException;

    DTOBeneficiariesCode findByBeneficiariesCode(String beneficiariesCode) throws DAOException;

    /**
     * It modifies the relationship between a beneficiary and their property.
     *
     * @param dto object with the data of the beneficiary-property association
     * @return {@code true} if the modification was successful
     * @throws DAOException if an error occurs during the operation
     */
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws DAOException;

    /**
     * Get the latest registered beneficiary code.
     *
     * @return last sequential code of the beneficiary
     * @throws DAOException if an error occurs in the query
     */
    int getLastCode() throws DAOException;

    /**
     * Gets the count of registered beneficiaries per month for the
     * last {@code months} months.
     *
     * @param months number of months to consult
     * @return List of DTOs with the monthly count of beneficiaries
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
     * Calculate the percentage of beneficiaries who have an associated
     * property in relation to the total.
     *
     * @return Percentage of beneficiaries with property (0–100)
     * @throws DAOException if an error occurs in the query
     */
    int percentBeneficiariesWithProperty() throws DAOException;

}
