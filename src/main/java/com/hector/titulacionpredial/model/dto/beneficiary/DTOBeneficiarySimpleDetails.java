package com.hector.titulacionpredial.model.dto.beneficiary;

public class DTOBeneficiarySimpleDetails {

    private String name;
    private String lastName;
    private int code;

    public DTOBeneficiarySimpleDetails() {

    }

    public DTOBeneficiarySimpleDetails(String name, String lastName, int code) {
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCode() {
        return code;
    }
    
}
