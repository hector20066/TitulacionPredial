package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertySimpleDetails;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.util.List;

/**
 * Facade that defines the high-level operations for property management
 * in the system.
 *
 * <p>
 * It extends {@link IListable}, {@link IRemovable} and {@link ICountable}
 * to offer listing, deletion and counting of properties, in addition to
 * specific operations such as export and statistics.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see PropertyImplFacade
 * @since 1.0
 */
public interface PropertyFacade extends IListable<DTOPropertyDetails>, IRemovable, ICountable {

    /**
     * Register a new property in the system.
     *
     * @param cadastralId  cadastral certificate of the property
     * @param address      property address
     * @param department   department/region of the property
     * @param municipality municipality where the property is located
     * @param crossing     property crossing/intersection details
     * @param neighborhood neighborhood name
     * @param publication  publication reference or number
     * @return code of the newly inserted property
     * @throws DAOException if an error occurs during the operation
     */
    int add(String cadastralId, String address, Department department, Municipalities municipality,
            String crossing, String neighborhood, String publication) throws DAOException;

    /**
     * Search for a property using its cadastral certificate.
     *
     * @param cadastralId cadastral certificate
     * @return DTO with detailed property information
     * @throws DAOException if an error occurs or it is not found
     */
    DTOPropertyDetails findByCode(String cadastralId) throws DAOException;

    /**
     * It obtains all properties in export format.
     *
     * @return list of DATA with complete data
     * @throws DAOException if an error occurs in the query
     */
    List<DTOPropertyDetails> findByAllForExport() throws DAOException;

    /**
     * It obtains all properties for a specific municipality.
     *
     * @param municipality the municipality to filter by
     * @return list of properties from the selected municipality
     * @throws DAOException if an error occurs in the query
     */
    List<DTOPropertyDetails> findByMunicipality(Municipalities municipality) throws DAOException;

    /**
     * Retrieve simplified property details using the cadastral reference.
     *
     * @param cadastralRef the cadastral reference of the property
     * @return DTO with simplified property information
     * @throws DAOException if an error occurs or the property is not found
     */
    DTOPropertySimpleDetails findSimpleDetails(String cadastralRef) throws DAOException;

    /**
     * Modify the basic information of an existing property.
     *
     * @param department         the new department/region
     * @param municipality       the new municipality
     * @param neighborhood       the new neighborhood name
     * @param address            the new property address
     * @param crossing           the new property crossing/intersection details
     * @param publication        the new publication reference
     * @param cadastralReference the cadastral reference of the property to modify
     * @return true if the modification was successful, false otherwise
     * @throws DAOException if an error occurs during the operation
     */
    boolean modifyBasicInformation(Department department, Municipalities municipality, String neighborhood, String address,
                                   String crossing, String publication, String cadastralReference) throws DAOException;

    /**
     * Update a property's cadastral reference and area.
     *
     * @param cadastralReference the property's cadastral reference
     * @param area               the property area value
     * @return true if the modification was successful, false otherwise
     * @throws DAOException if an error occurs during the operation
     */
    boolean modify(String cadastralReference, double area) throws DAOException;

    /**
     * Calculate the percentage of properties with a resolution.
     *
     * @return percentage (0–100)
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
