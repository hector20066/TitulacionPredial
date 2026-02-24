package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.*;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiary {

    protected Department department;
    protected Municipalities municipality;
    protected String neighborhood;
    protected String address;
    protected long phone;
    protected String crossing;
    protected String publication;
    protected MaritalStatus maritalStatus;
    protected String affectation;

    public DTOBeneficiary() {

    }

    public DTOBeneficiary(Builder<?> builder) {
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

    public static class Builder<T extends Builder<T>> {

        private Department department;
        private Municipalities municipality;
        private String neighborhood;
        private String address;
        private long phone;
        private String crossing;
        private String publication;
        private MaritalStatus maritalStatus;
        private String affectation;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T department(Department department) {
            this.department = department;
            return self();
        }

        public T municipality(Municipalities municipalities) {
            this.municipality = municipalities;
            return self();
        }

        public T neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return self();
        }

        public T address(String address) {
            this.address = address;
            return self();
        }

        public T phone(long phone) {
            this.phone = phone;
            return self();
        }

        public T crossing(String crossing) {
            this.crossing = crossing;
            return self();
        }

        public T publication(String publication) {
            this.publication = publication;
            return self();
        }

        public T maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return self();
        }

        public T affectation(String affectation) {
            this.affectation = affectation;
            return self();
        }

        public DTOBeneficiary build() {
            return new DTOBeneficiary(this);
        }

    }

}
