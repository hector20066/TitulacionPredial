package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public interface UsersFacade extends IListable<DTOUserDetails>, IRemovable {

    void add(String name, long id, String user, String plainPassword, Role role) throws DAOException;
    DTOUserDetails findByCode(int code) throws DAOException;
    boolean verifyCredentials(String user, String plainPassword) throws DAOException;
    boolean modifyPassword(DTOUserModifyPasswd dto) throws DAOException;

}
