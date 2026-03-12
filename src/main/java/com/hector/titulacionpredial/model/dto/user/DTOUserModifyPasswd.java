package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserModifyPasswd extends DTOUser {

    private String password;

    public DTOUserModifyPasswd() {

    }

    public DTOUserModifyPasswd(String password, long id) {
        super(id);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

}
