package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.time.LocalDate;
import java.util.List;

/**
 * Facade that defines the high-level operations for managing
 * resolutions in the system.
 *
 * <p>
 * Extends {@link IListable} and {@link ICountable} to offer
 * resolution listing and counting, in addition to create,
 * search, and modify operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ResolutionImplFacade
 * @since 1.0
 */
public interface ResolutionFacade extends IListable<DTOResolutionDetails>, ICountable {

    /**
     * Register a new resolution in the system.
     *
     * @param resolutionNumber resolution number
     * @param notification     notification date
     * @param executory        date of execution
     * @param fmi              real estate registration number
     * @param act              adt
     * @param publicWriting    public deed
     * @param notary           notary
     * @param propertyCode     associated property code
     * @param beneficiaryName  beneficiary name
     * @throws DAOException if an error occurs during the operation
     */
    void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act,
             String publicWriting, String notary, int propertyCode, String beneficiaryName) throws DAOException;

    /**
     * Look for a resolution by its number.
     *
     * @param numResolution resolution number
     * @return DTO with the detailed data of the resolution
     * @throws DAOException if an error occurs or it is not found
     */
    DTOResolutionDetails findByCode(int numResolution) throws DAOException;

    /**
     * It obtains all resolutions for a specific municipality.
     *
     * @param municipality the municipality to filter by
     * @return list of resolutions from the selected municipality
     * @throws DAOException if an error occurs in the query
     */
    List<DTOResolutionDetails> findByMunicipality(Municipalities municipality) throws DAOException;

    /**
     * Modify the data of an existing resolution.
     *
     * @param code          resolution code to be modified
     * @param executory     updated execution date
     * @param act           update act
     * @param publicWriting updated public deed
     * @param numResolution updated resolution number
     * @param notification  updated notification date
     * @param fmi           updated FMI
     * @param notary        updated notary
     * @return {@code true} if the modification was successful
     * @throws DAOException if an error occurs during the operation
     */
    boolean modify(int code, LocalDate executory, String act, String publicWriting, long numResolution,
                   LocalDate notification, String fmi, String notary) throws DAOException;

    /**
     * Count the total number of resolution records for a specific municipality.
     *
     * @param municipality the municipality to filter by
     * @return number of resolution records in the specified municipality
     * @throws DAOException if an error occurs in the query
     */
    int countRecordsByMunicipality(Municipalities municipality) throws DAOException;

}
