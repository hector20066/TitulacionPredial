package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 *
 * @author hectoracevedo
 */
public interface SpouseFacade extends IRemovable {

    void add(long id, String fullName, String expeditionLocation, String address, long phone, int beneficiaryCode) throws Exception;
    DTOSpouse findByCode(int id) throws Exception;

}
