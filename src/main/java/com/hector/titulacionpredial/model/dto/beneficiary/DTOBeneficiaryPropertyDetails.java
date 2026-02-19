package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryPropertyDetails {
    //DTO para consulta en Property utilizando JOIN
    private String fullName;
    private int code;

    public DTOBeneficiaryPropertyDetails() {

    }

    public DTOBeneficiaryPropertyDetails(String fullName, int code) {
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
