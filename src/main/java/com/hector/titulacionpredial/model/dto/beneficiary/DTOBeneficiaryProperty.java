package com.hector.titulacionpredial.model.dto.beneficiary;

public class DTOBeneficiaryProperty {

    private int beneficiaryCode;
    private int propertyCode;

    public DTOBeneficiaryProperty() {

    }

    public DTOBeneficiaryProperty(int beneficiaryCode, int propertyCode) {
        this.beneficiaryCode = beneficiaryCode;
        this.propertyCode = propertyCode;
    }

    public void setBeneficiaryCode(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }
    
}
