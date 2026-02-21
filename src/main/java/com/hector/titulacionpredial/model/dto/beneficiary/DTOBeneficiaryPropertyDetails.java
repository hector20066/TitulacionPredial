package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryPropertyDetails {

    private String fullName;
    private int id;
    private Municipalities municipalities;
    private String address;

    public DTOBeneficiaryPropertyDetails() {

    }

    public DTOBeneficiaryPropertyDetails(String fullName, int code, Municipalities municipality, String address) {
        this.fullName = fullName;
        this.id = code;
        this.municipalities = municipality;
        this.address = address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCode(int code) {
        this.id = code;
    }

    public void setMunicipalities(Municipalities municipalities) {
        this.municipalities = municipalities;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public Municipalities getMunicipalities() {
        return municipalities;
    }

    public String getAddress() {
        return address;
    }

}
