package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.*;

/**
 *
 * @author hectoracevedo
 */
public class Beneficiary extends Person {

    private int code;
    private Department department;
    private Municipalities municipality;
    private String cadastralReference;
    private MaritalStatus maritalStatus;
    private String affectation;
    private String crossing;
    private String publication;
    private String neighborhood;

    public Beneficiary() {

    }

    public Beneficiary(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.cadastralReference = builder.cadastralReference;
        this.maritalStatus = builder.maritalStatus;
        this.affectation = builder.affectation;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
        this.neighborhood = builder.neighborhood;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    public void setCadastralReference(String cadastralReference) {
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

    public Municipalities getMunicipality() {
        return municipality;
    }

    public String getCadastralReference() {
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

    public static class Builder extends Person.Builder<Builder> {

        private int code;
        private Department department;
        private Municipalities municipality;
        private String cadastralReference;
        private MaritalStatus maritalStatus;
        private String affectation;
        private String crossing;
        private String publication;
        private String neighborhood;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Builder municipality(Municipalities municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder cadastralReference(String cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        public Builder maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        @Override
        public Beneficiary build() {
            return new Beneficiary(this);
        }

    }

}
