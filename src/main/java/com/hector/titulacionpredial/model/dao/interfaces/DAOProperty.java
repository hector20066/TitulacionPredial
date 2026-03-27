package com.hector.titulacionpredial.model.dao.interfaces;

import java.util.List;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyUpdate;
import com.hector.titulacionpredial.model.enums.Municipalities;

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

}
