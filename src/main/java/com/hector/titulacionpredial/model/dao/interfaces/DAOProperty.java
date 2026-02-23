package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.property.*;

/**
 *
 * @author hectoracevedo
 */
public interface DAOProperty extends IListable<DTOPropertyDetails>,
        IRemovable,
        ICountable {

    int add(DTOPropertyCreate dto) throws Exception;
    DTOPropertyDetails findByCode(String cadastralId) throws Exception;
    int percentPropertiesWithResolutions() throws Exception;
    int countPropertyWithResolution() throws Exception;

}
