package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public interface DAOUser extends DAOBase<DTOUserCreate, DTOUserDetails>, IListable<DTOUserDetails>, IRemovable {

    Role verifyCredentials(String user, String plainPassword) throws DAOException;
    boolean modifyPassword(DTOUserModifyPasswd dto) throws DAOException;

}
