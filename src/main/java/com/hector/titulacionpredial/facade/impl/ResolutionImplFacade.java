package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOResolutionImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;

import java.time.LocalDate;
import java.util.List;

/**
 * Implementación de la fachada {@link ResolutionFacade} para la
 * gestión de resoluciones.
 *
 * <p>
 * Construye los DTOs necesarios a partir de los parámetros
 * recibidos y delega las operaciones al DAO
 * {@link DAOResolutionImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ResolutionFacade
 * @see DAOResolutionImpl
 * @since 1.0
 */
public class ResolutionImplFacade implements ResolutionFacade {

    /**
     * DAO delegado para operaciones de resoluciones.
     */
    private final DAOResolution daoResolution;

    /**
     * Crea una nueva instancia obteniendo el DAO
     * de resoluciones mediante su Singleton.
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
