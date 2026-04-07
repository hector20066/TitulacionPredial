package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.property.*;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.util.List;

/**
 * DAO interface for managing properties in the database.
 *
 * <p>
 * Unlike other DAOs, it does not directly extend {@link DAOBase}
 * because the {@code add} method returns the code of the inserted
 * property. It includes listing, deletion, counting, and statistics
 * operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see IListable
 * @see IRemovable
 * @see ICountable
 * @since 1.0
 */
public interface DAOProperty extends IListable<DTOPropertyDetails>,
        IRemovable,
        ICountable,
        IModifiable<DTOPropertyUpdate> {

    /**
     * Insert a new property into the database.
     *
     * @param dto object with the data of the property to be registered
     * @return code of the newly inserted property
     * @throws DAOException if an error occurs during the operation
     */
    int add(DTOPropertyCreate dto) throws DAOException;

    /**
     * Search for a property using its cadastral certificate.
     *
     * @param cadastralId cadastral certificate of the property
     * @return DTO with detailed property information
     * @throws DAOException if an error occurs or the record is not found
     */
    DTOPropertyDetails findByCode(String cadastralId) throws DAOException;

    /**
     * It obtains all properties in export format.
     *
     * @return List of DTOs with complete data for each property
     * @throws DAOException if an error occurs in the query
     */
    List<DTOPropertyDetails> findByAllForExport() throws DAOException;

    /**
     * It obtains all properties for a specific municipality.
     *
     * @param municipality the municipality to filter by
     * @return List of DTOs with properties from the selected municipality
     * @throws DAOException if an error occurs in the query
     */
    List<DTOPropertyDetails> findByMunicipality(Municipalities municipality) throws DAOException;

    /**
     * Retrieve simplified details of a property by its cadastral reference.
     *
     * <p>
     * This method returns a lightweight version of property information
     * containing only the most essential details.
     * </p>
     *
     * @param cadastralReference the cadastral reference identifier of the property
     * @return DTO with simplified property information
     * @throws DAOException if an error occurs or the record is not found
     */
    DTOPropertySimpleDetails findSimpleDetails(String cadastralReference) throws DAOException;

    /**
     * Modify the basic information of an existing property.
     *
     * <p>
     * Updates essential property attributes such as name, municipality,
     * address, and other fundamental data. This method does not modify
     * the cadastral reference or other protected fields.
     * </p>
     *
     * @param dto data transfer object containing the updated basic information
     * @return {@code true} if the modification was successful, {@code false} otherwise
     * @throws DAOException if an error occurs during the update operation
     */
    boolean modifyBasicInformation(DTOPropertyModifyBasic dto) throws DAOException;

    /**
     * Calculate the percentage of properties that have an
     * associated resolution with respect to the total.
     *
     * @return Percentage of properties with resolution (0–100)
     * @throws DAOException if an error occurs in the query
     */
    int percentPropertiesWithResolutions() throws DAOException;

    /**
     * It counts the properties that have an associated resolution.
     *
     * @return number of properties with resolution
     * @throws DAOException if an error occurs in the query
     */
    int countPropertyWithResolution() throws DAOException;

    /**
     * Count the total number of property records for a specific municipality.
     *
     * @param municipality the municipality to filter by
     * @return number of property records in the specified municipality
     * @throws DAOException if an error occurs in the query
     */
    int countRecordsByMunicipality(Municipalities municipality) throws DAOException;

}
