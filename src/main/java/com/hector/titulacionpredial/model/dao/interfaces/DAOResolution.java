package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.resolution.*;

/**
 *
 * @author hectoracevedo
 */
public interface DAOResolution extends DAOBase<DTOResolutionCreate, DTOResolutionDetails>,
        IListable<DTOResolutionDetails>,
        IModifiable<DTOResolutionUpdate>,
        ICountable {

}
