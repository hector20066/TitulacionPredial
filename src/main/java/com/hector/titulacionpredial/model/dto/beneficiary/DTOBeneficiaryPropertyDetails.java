package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiarySimpleDetails {

    private String fullName;
    private int code;

    public DTOBeneficiarySimpleDetails() {

    }

    public DTOBeneficiarySimpleDetails(String fullName, int code) {
        this.fullName = fullName;
        this.code = code;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCode() {
        return code;
    }

}
