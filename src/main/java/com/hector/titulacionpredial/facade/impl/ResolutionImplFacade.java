package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOResolutionImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class ResolutionImplFacade implements ResolutionFacade {

    private final DAOResolution daoResolution;

    public ResolutionImplFacade() {
        this.daoResolution = DAOResolutionImpl.getInstance();
    }

    @Override
    public void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary, int propertyCode) throws Exception {

    }

    @Override
    public DTOResolutionDetails findByCode(int numResolution) throws Exception {
        return null;
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean modify(LocalDate executory, String act, String publicWriting, long numResolution) throws Exception {
        return false;
    }

    @Override
    public int countRecords() throws Exception {
        return 0;
    }

}
