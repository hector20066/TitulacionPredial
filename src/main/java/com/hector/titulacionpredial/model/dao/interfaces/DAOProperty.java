package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

/**
 *
 * @author hectoracevedo
 */
public interface DAOProperty extends DAOBase<DTOPropertyCreate, DTOPropertyDetails>,
        IListable<DTOPropertyDetails>,
        IRemovable,
        ICountable {

}
