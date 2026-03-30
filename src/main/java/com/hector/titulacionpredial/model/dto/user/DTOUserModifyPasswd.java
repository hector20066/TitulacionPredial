package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserModifyPasswd extends DTOUser {

    private String password;

    /**     * dto user modify passwd.     * @return the dto user modify passwd     */
    public DTOUserModifyPasswd() {
        super();
    }

    /**     * dto user modify passwd.     * @param password the password     * @param id the id     * @return the dto user modify passwd     */
    public DTOUserModifyPasswd(String password, int id) {
        super(id);
        this.password = password;
    }

    /**     * get password.     * @return the get password     */
    public String getPassword() {
        return password;
    }

    /**     * set password.     * @param password the password     */
    public void setPassword(String password) {
        this.password = password;
    }

}
