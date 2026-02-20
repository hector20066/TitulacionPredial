package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

/**
 *
 * @author hectoracevedo
 */
public interface DAOProperty extends IListable<DTOPropertyDetails>,
        IRemovable,
        ICountable {

    int add(DTOPropertyCreate dto) throws Exception;
    DTOPropertyDetails findByCode(int code) throws Exception;

}
