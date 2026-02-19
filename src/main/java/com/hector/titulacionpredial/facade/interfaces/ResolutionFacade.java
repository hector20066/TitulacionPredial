package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface ResolutionFacade {

    void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary, int propertyCode) throws Exception;
    DTOResolutionDetails findByCode(int numResolution) throws Exception;
    List<DTOResolutionDetails> findByAll() throws Exception;
    boolean modify(LocalDate executory, String act, String publicWriting, long numResolution) throws Exception;
    int countRecords() throws Exception;
}
