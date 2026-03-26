package com.hector.titulacionpredial.model.dto.beneficiary;

public class DTOBeneficiariesCode {

    private String cadastral_reference;
    private String address;
    private int code;

    public DTOBeneficiariesCode() {

    }

    public DTOBeneficiariesCode(String cadastral_reference, String address, int code) {
        this.cadastral_reference = cadastral_reference;
        this.address = address;
        this.code = code;
    }

    public String getCadastral_reference() {
        return cadastral_reference;
    }

    public void setCadastral_reference(String cadastral_reference) {
        this.cadastral_reference = cadastral_reference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
