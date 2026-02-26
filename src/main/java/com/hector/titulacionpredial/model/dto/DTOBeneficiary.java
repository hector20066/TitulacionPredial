package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiary extends DTOBasePerson {

    protected Department department;
    protected Municipalities municipality;
    protected String neighborhood;
    protected String crossing;
    protected String publication;
    protected MaritalStatus maritalStatus;
    protected String affectation;

    public DTOBeneficiary() {
        super();
    }

    public DTOBeneficiary(Builder<?> builder) {
        super(builder.address, builder.phone);

        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
        this.maritalStatus = builder.maritalStatus;
        this.affectation = builder.affectation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Municipalities getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCrossing() {
        return crossing;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
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
