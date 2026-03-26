package com.hector.titulacionpredial.model.dto.beneficiary;

public class DTOBeneficiariesCode {

    private String cadastral_reference;
    private String address;

    public DTOBeneficiariesCode() {

    }

    public DTOBeneficiariesCode(String cadastral_reference, String address) {
        this.cadastral_reference = cadastral_reference;
        this.address = address;
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

}
