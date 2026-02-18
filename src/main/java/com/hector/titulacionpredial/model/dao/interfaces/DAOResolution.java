package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface DAOResolution {

    void add(DTOResolutionCreate dto) throws Exception;
    DTOResolutionDetails findByCode(int code) throws Exception;
    List<DTOResolutionDetails> findByAll() throws Exception;
    boolean modify(DTOResolutionUpdate dto) throws Exception;

}
