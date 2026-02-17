package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.entities.Property;
import com.hector.titulacionpredial.model.enums.MaritalStatus;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryCreate {

    private long id;
    private String name;
    private String lastName;
    private String expeditionLocation;
    private String department;
    private String municipality;
    private String neighborhood;
    private String address;
    private long phone;
    private long cadastralReference;
    private String crossing;
    private String publication;
    private MaritalStatus maritalStatus;
    private String affectation;
    private Property property;

    public DTOBeneficiaryCreate() {

    }

    public DTOBeneficiaryCreate(long id, String name, String lastName, String expeditionLocation, String department, String municipality, String neighborhood, String address, long phone, long cadastralReference, String crossing, String publication, MaritalStatus maritalStatus, String affectation, Property property) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.expeditionLocation = expeditionLocation;
        this.department = department;
        this.municipality = municipality;
        this.neighborhood = neighborhood;
        this.address = address;
        this.phone = phone;
        this.cadastralReference = cadastralReference;
        this.crossing = crossing;
        this.publication = publication;
        this.maritalStatus = maritalStatus;
        this.affectation = affectation;
        this.property = property;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
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

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
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

    public void setProperty(Property property) {
        this.property = property;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
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

    public long getCadastralReference() {
        return cadastralReference;
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

    public Property getProperty() {
        return property;
    }

}
