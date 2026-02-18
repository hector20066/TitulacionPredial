package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.point.DTOPointCreate;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

/**
 *
 * @author hectoracevedo
 */
public interface DAOPoint extends DAOBase<DTOPointCreate, DTOPointDetails> {

    DTOPointDetails findById(int id) throws Exception;

}
