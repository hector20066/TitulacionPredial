package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;

/**
 *
 * @author hectoracevedo
 */
public class Beneficiary extends Person {

    private int code;
    private Department department;
    private String municipality;
    private long cadastralReference;
    private MaritalStatus maritalStatus;
    private String affectation;
    private String crossing;
    private String publication;
    private String neighborhood;

    public Beneficiary() {

    }

    public Beneficiary(long id, String name, String lastName, String address, String expeditionLocation, long phone, int code, Department department, String municipality, long cadastralReference, MaritalStatus maritalStatus, String affectation, String crossing, String publication, String neighborhood) {
        super(id, name, lastName, address, expeditionLocation, phone);
        this.code = code;
        this.department = department;
        this.municipality = municipality;
        this.cadastralReference = cadastralReference;
        this.maritalStatus = maritalStatus;
        this.affectation = affectation;
        this.crossing = crossing;
        this.publication = publication;
        this.neighborhood = neighborhood;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getCode() {
        return code;
    }

    public Department getDepartment() {
        return department;
    }

    public String getMunicipality() {
        return municipality;
    }

    public long getCadastralReference() {
        return cadastralReference;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public String getAffectation() {
        return affectation;
    }

    public String getCrossing() {
        return crossing;
    }

    public String getPublication() {
        return publication;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCode= " + code +
                "\nDepartment= " + department +
                "\nMunicipality= " + municipality +
                "\nCadastralReference= " + cadastralReference +
                "\nMaritalStatus= " + maritalStatus +
                "\nAffectation= " + affectation +
                "\nCrossing= " + crossing +
                "\nPublication= " + publication +
                "\nNeighborhood= " + neighborhood;
    }

}
