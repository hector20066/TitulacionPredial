package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface PropertyFacade {

    void add(String cadastralId, Double area) throws Exception;
    DTOPointDetails findByCode(int code) throws Exception;
    List<DTOPointDetails> findByAll() throws Exception;
    void delete(int code) throws Exception;
    int countRecords() throws Exception;
}
