package com.hector.titulacionpredial.model.dto;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUser {

    protected long id;

    public DTOUser() {

    }

    public DTOUser(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
