package com.hector.titulacionpredial.facade.impl;

import java.util.List;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOUserImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOUser;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.model.security.BCryptEncryption;

/**
 * Implementation of the {@link UsersFacade} facade for
 * user account management.
 *
 * <p>
 * Build the necessary DATA from the received parameters and
 * delegate the operations to the DAO {@link DAOUserImpl}.
 * Handles password encryption using {@link BCryptEncryption}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see UsersFacade
 * @see DAOUserImpl
 * @see BCryptEncryption
 * @since 1.0
 */
public class UsersImplFacade implements UsersFacade {

    private final DAOUser daoUser;

    /**
     * Create a new instance by obtaining the user DAO
     * through its Singleton.
     */
    public UsersImplFacade() {
        this.daoUser = DAOUserImpl.getInstance();
    }

    @Override
    public void add(String name, int id, String user, String plainPassword, Role role) throws DAOException {
        String hashedPassword = BCryptEncryption.encryptPassword(plainPassword);

        DTOUserCreate dto = new DTOUserCreate.Builder()
                .name(name)
                .id(id)
                .user(user)
                .password(hashedPassword)
                .role(role)
                .build();

        daoUser.add(dto);
    }

    @Override
    public DTOUserDetails findByCode(int code) throws DAOException {
        return daoUser.findByCode(code);
    }

    @Override
    public Role verifyCredentials(String user, String plainPassword) throws DAOException {
        return daoUser.verifyCredentials(user, plainPassword);
    }

    @Override
    public boolean modifyPassword(int id, String plainPassword) throws DAOException {
        DTOUserModifyPasswd dto = new DTOUserModifyPasswd();
        dto.setId(id);
        String hashedPassword = BCryptEncryption.encryptPassword(plainPassword);
        dto.setPassword(hashedPassword);

        return daoUser.modifyPassword(dto);
    }

    @Override
    public List<DTOUserDetails> findByAll() throws DAOException {
        return daoUser.findByAll();
    }

    @Override
    public void delete(int code) throws DAOException {
        daoUser.delete(code);
    }

}
