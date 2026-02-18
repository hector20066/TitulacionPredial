package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DAOResolutionImpl implements DAOResolution {

    @Override
    public void add(DTOResolutionCreate dto) throws Exception {

    }

    @Override
    public DTOResolutionDetails findByCode(int code) throws Exception {
        return null;
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean modify(DTOResolutionUpdate dto) throws Exception {
        return false;
    }

}
