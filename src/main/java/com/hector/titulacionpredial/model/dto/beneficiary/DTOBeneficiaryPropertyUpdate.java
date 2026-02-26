package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryPropertyUpdate {

    private int beneficiaryCode;
    private int propertyCode;

    public DTOBeneficiaryPropertyUpdate() {

    }

    public DTOBeneficiaryPropertyUpdate(int beneficiaryCode, int propertyCode) {
        this.beneficiaryCode = beneficiaryCode;
        this.propertyCode = propertyCode;
    }

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public void setBeneficiaryCode(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

}
