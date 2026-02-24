package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOBasePerson {

    protected String address;
    protected long phone;

    public DTOBasePerson() {

    }

    public DTOBasePerson(String address, long phone) {
        this.address = address;
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

}
