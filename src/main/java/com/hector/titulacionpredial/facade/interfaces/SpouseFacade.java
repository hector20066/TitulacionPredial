package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 *
 * @author hectoracevedo
 */
public interface SpouseFacade extends IRemovable {

    void add(long id, String fullName, String expeditionLocation, String address, long phone,
             int beneficiaryCode) throws DAOException;

    DTOSpouse findByCode(int id) throws DAOException;

}
