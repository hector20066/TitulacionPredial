package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOResolutionImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.*;

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
    public void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary, int propertyCode, String beneficiaryName) throws Exception {
        DTOResolutionCreate dto = new DTOResolutionCreate.Builder()
                .resolutionNumber(resolutionNumber)
                .notification(notification)
                .executory(executory)
                .act(act)
                .publicWriting(publicWriting)
                .fmi(fmi)
                .notary(notary)
                .propertyCode(propertyCode)
                .beneficiaryName(beneficiaryName)
                .build();

        daoResolution.add(dto);
    }

    @Override
    public DTOResolutionDetails findByCode(int numResolution) throws Exception {
        return daoResolution.findByCode(numResolution);
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws Exception {
        return daoResolution.findByAll();
    }

    @Override
    public boolean modify(int code, LocalDate executory, String act, String publicWriting, long numResolution, LocalDate notification, String fmi, String notary) throws Exception {
        DTOResolutionUpdate dto = new DTOResolutionUpdate.Builder()
                .resolutionNumber(numResolution)
                .executory(executory)
                .act(act)
                .publicWriting(publicWriting)
                .code(code)
                .notification(notification)
                .fmi(fmi)
                .notary(notary)
                .build();

        return daoResolution.modify(dto);
    }

    @Override
    public int countRecords() throws Exception {
        return daoResolution.countRecords();
    }

}
