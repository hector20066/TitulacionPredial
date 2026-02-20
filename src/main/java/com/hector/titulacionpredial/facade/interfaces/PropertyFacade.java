package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

/**
 *
 * @author hectoracevedo
 */
public interface PropertyFacade extends IListable<DTOPropertyDetails>, IRemovable, ICountable {

    int add(String cadastralId, Double area) throws Exception;
    DTOPropertyDetails findByCode(String cadastralId) throws Exception;

}
