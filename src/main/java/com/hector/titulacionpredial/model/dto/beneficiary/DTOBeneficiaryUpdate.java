package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.enums.MaritalStatus;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryUpdate {

    private String department;
    private String municipality;
    private String neighborhood;
    private String address;
    private long phone;
    private String crossing;
    private String publication;
    private MaritalStatus maritalStatus;
    private String affectation;

    public DTOBeneficiaryUpdate() {

    }

    public DTOBeneficiaryUpdate(String department, String municipality, String neighborhood, String address, long phone, String crossing, String publication, MaritalStatus maritalStatus, String affectation) {
        this.department = department;
        this.municipality = municipality;
        this.neighborhood = neighborhood;
        this.address = address;
        this.phone = phone;
        this.crossing = crossing;
        this.publication = publication;
        this.maritalStatus = maritalStatus;
        this.affectation = affectation;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    public String getDepartment() {
        return department;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public String getCrossing() {
        return crossing;
    }

    public String getPublication() {
        return publication;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public String getAffectation() {
        return affectation;
    }

}
