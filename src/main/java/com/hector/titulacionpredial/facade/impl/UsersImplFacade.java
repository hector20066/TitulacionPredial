package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOUserImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOUser;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.model.dto.user.DTOUserModifyPasswd;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.model.security.BCryptEncryption;

import java.util.List;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class UsersImplFacade implements UsersFacade {

    private final DAOUser daoUser;

    /**     * users impl facade.     * @return the users impl facade     */
    public UsersImplFacade() {
        this.daoUser = DAOUserImpl.getInstance();
    }

    @Override
    /**     * add.     * @param name the name     * @param id the id     * @param user the user     * @param plainPassword the plain password     * @param role the role     */
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
    /**     * find by code.     * @param code the code     * @return the find by code     */
    public DTOUserDetails findByCode(int code) throws DAOException {
        return daoUser.findByCode(code);
    }

    @Override
    /**     * verify credentials.     * @param user the user     * @param plainPassword the plain password     * @return the verify credentials     */
    public Role verifyCredentials(String user, String plainPassword) throws DAOException {
        return daoUser.verifyCredentials(user, plainPassword);
    }

    @Override
    /**     * modify password.     * @param id the id     * @param plainPassword the plain password     * @return the modify password     */
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
    /**     * delete.     * @param code the code     */
    public void delete(int code) throws DAOException {
        daoUser.delete(code);
    }

}
