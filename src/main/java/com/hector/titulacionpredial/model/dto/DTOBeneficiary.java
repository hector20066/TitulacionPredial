package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiary {

    private Department department;
    private Municipalities municipality;
    private String neighborhood;
    private String address;
    private long phone;
    private String crossing;
    private String publication;
    private MaritalStatus maritalStatus;
    private String affectation;

    public DTOBeneficiary() {

    }

    public DTOBeneficiary(Builder builder) {
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.address = builder.address;
        this.phone = builder.phone;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
        this.maritalStatus = builder.maritalStatus;
        this.affectation = builder.affectation;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setMunicipality(Municipalities municipality) {
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

    public Department getDepartment() {
        return department;
    }

    public Municipalities getMunicipality() {
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

    public static class Builder {

        private Department department;
        private Municipalities municipality;
        private String neighborhood;
        private String address;
        private long phone;
        private String crossing;
        private String publication;
        private MaritalStatus maritalStatus;
        private String affectation;

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Builder municipality(Municipalities municipalities) {
            this.municipality = municipalities;
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(long phone) {
            this.phone = phone;
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

        public Builder maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        public DTOBeneficiary build() {
            return new DTOBeneficiary(this);
        }

    }

}
