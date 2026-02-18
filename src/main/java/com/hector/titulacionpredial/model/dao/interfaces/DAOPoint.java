package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.point.DTOPointCreate;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

/**
 *
 * @author hectoracevedo
 */
public interface DAOPoint {

    void add(DTOPointCreate dto) throws Exception;
    DTOPointDetails findById(int id) throws Exception;
    DTOPointDetails findByPropertyCode(int propertyCode) throws Exception;

}
