package com.hector.titulacionpredial.model.dto.spouse;

import com.hector.titulacionpredial.model.entities.Beneficiary;

import javax.swing.plaf.DesktopPaneUI;

/**
 *
 * @author hectoracevedo
 */
public class DTOSpouseCreate {

    private long id;
    private String name;
    private String lastName;
    private String expeditionLocation;
    private String address;
    private long phone;
    private int beneficiaryCode;

    public DTOSpouseCreate() {

    }

    public DTOSpouseCreate(long id, String name, String lastName, String expeditionLocation, String address, long phone, int beneficiaryCode) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.expeditionLocation = expeditionLocation;
        this.address = address;
        this.phone = phone;
        this.beneficiaryCode = beneficiaryCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setBeneficiary(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public int getBeneficiary() {
        return beneficiaryCode;
    }

}
