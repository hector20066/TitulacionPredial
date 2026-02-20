package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryPropertyDetails {

    private String fullName;
    private int id;
    private String neighborhood;
    private String address;

    public DTOBeneficiaryPropertyDetails() {

    }

    public DTOBeneficiaryPropertyDetails(String fullName, int code, String neighborhood, String address) {
        this.fullName = fullName;
        this.id = code;
        this.neighborhood = neighborhood;
        this.address = address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCode(int code) {
        this.id = code;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getAddress() {
        return address;
    }

}
