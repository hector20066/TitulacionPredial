package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.util.List;

/**
 * DAO interface for managing resolutions in the database.
 *
 * <p>
 * Extends the base interfaces to provide creation, code
 * search, listing, modification, and counting operations
 * on the {@code Resolution} entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBase
 * @see IListable
 * @see IModifiable
 * @see ICountable
 * @since 1.0
 */
public interface DAOResolution extends DAOBase<DTOResolutionCreate, DTOResolutionDetails>,
        IListable<DTOResolutionDetails>,
        IModifiable<DTOResolutionUpdate>,
        ICountable {

    /**
     * It obtains all resolutions for a specific municipality.
     *
     * @param municipality the municipality to filter by
     * @return List of resolutions from the selected municipality
     * @throws DAOException if an error occurs in the query
     */
    List<DTOResolutionDetails> findByMunicipality(Municipalities municipality) throws DAOException;

}
