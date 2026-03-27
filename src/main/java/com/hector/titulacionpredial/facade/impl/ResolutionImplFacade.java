package com.hector.titulacionpredial.facade.impl;

import java.time.LocalDate;
import java.util.List;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOResolutionImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Implementation of the {@link ResolutionFacade} facade
 * for resolution management.
 *
 * <p>
 * Build the necessary DATA from the received parameters and
 * delegate the operations to the DAO {@link DAOResolutionImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ResolutionFacade
 * @see DAOResolutionImpl
 * @since 1.0
 */
public class ResolutionImplFacade implements ResolutionFacade {

    private final DAOResolution daoResolution;

    /**
     * Create a new instance by obtaining the resolutions
     * DAO through your Singleton.
     */
    public ResolutionImplFacade() {
        this.daoResolution = DAOResolutionImpl.getInstance();
    }

    @Override
    public void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act,
                    String publicWriting, String notary, int propertyCode, String beneficiaryName) throws DAOException {

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
    public DTOResolutionDetails findByCode(int numResolution) throws DAOException {
        return daoResolution.findByCode(numResolution);
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws DAOException {
        return daoResolution.findByAll();
    }

    @Override
    public List<DTOResolutionDetails> findByMunicipality(Municipalities municipality) throws DAOException {
        return daoResolution.findByMunicipality(municipality);
    }

    @Override
    public boolean modify(int code, LocalDate executory, String act, String publicWriting, long numResolution,
                          LocalDate notification, String fmi, String notary) throws DAOException {

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
    public int countRecords() throws DAOException {
        return daoResolution.countRecords();
    }

}
