package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public interface ResolutionFacade extends IListable<DTOResolutionDetails>, ICountable {

    void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary, int propertyCode, String beneficiaryName) throws Exception;
    DTOResolutionDetails findByCode(int numResolution) throws Exception;
    boolean modify(int code, LocalDate executory, String act, String publicWriting, long numResolution, LocalDate notification, String fmi, String notary) throws Exception;

}
