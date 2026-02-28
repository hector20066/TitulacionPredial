package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;

/**
 * Interfaz DAO para la gestión de resoluciones en la base de datos.
 *
 * <p>
 * Extiende las interfaces base para ofrecer operaciones de
 * creación, búsqueda por código, listado, modificación y conteo
 * sobre la entidad {@code Resolution}.
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

}
