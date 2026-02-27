package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface PropertyFacade extends IListable<DTOPropertyDetails>, IRemovable, ICountable {

    int add(String cadastralId, Double area) throws DAOException;
    DTOPropertyDetails findByCode(String cadastralId) throws DAOException;
    List<DTOPropertyDetails> findByAllForExport() throws DAOException;
    int percentPropertiesWithResolutions() throws DAOException;
    int countPropertyWithResolution() throws DAOException;

}
