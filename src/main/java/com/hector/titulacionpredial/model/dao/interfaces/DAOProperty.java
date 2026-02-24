package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.property.*;

/**
 *
 * @author hectoracevedo
 */
public interface DAOProperty extends IListable<DTOPropertyDetails>,
        IRemovable,
        ICountable {

    int add(DTOPropertyCreate dto) throws DAOException;
    DTOPropertyDetails findByCode(String cadastralId) throws DAOException;
    int percentPropertiesWithResolutions() throws DAOException;
    int countPropertyWithResolution() throws DAOException;

}
