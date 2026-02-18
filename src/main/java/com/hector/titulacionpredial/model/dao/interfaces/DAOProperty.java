package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface DAOProperty {

    void add(DTOPropertyCreate dto) throws Exception;
    DTOPropertyDetails findByCode(int code) throws Exception;
    List<DTOPropertyDetails> findByAll() throws Exception;
    void delete(int code) throws Exception;

}
