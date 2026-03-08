package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Domain entity that represents a Beneficiary within the system.
 *
 * <p>
 * Extend {@link Person} by adding specific information related to
 * the graduation process, such as:
 * </p>
 *
 * <ul>
 *     <li>Internal beneficiary code.</li>
 *     <li>Geographic location (department and municipality).</li>
 *     <li>Associated cadastral reference.</li>
 *     <liMarital status.</li>
 *     <li>Additional legal and administrative information.</li>
 * </ul>
 *
 * <p>
 * This entity is part of the domain model and is persisted in
 * the database.
 * </p>
 *
 * <p>
 * Instance building is supported by the {@link Builder} pattern,
 * allowing fluid inheritance from {@link Person.Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
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
    private Spouse spouse;

    /**
     * Empty constructor required for persistence frameworks or
     * reflection-based mechanisms.
     */
    public Beneficiary() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    protected Beneficiary(Builder builder) {
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
        this.spouse = builder.spouse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getCadastralReference() {
        return cadastralReference;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    /**
     * Returns a textual representation of the beneficiary,
     * including inherited and specific attributes.
     *
     * @return formatted description of the beneficiary
     */
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

    /**
     * Concrete builder for the seamless construction of
     * {@link Beneficiary} instances.
     *
     * <p>
     * Extends {@link Person.Builder} to allow the configuration
     * of both inherited and specific attributes in the same
     * fluent string.
     * </p>
     */
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
        private Spouse spouse;

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

        public Builder spouse(Spouse spouse) {
            this.spouse = spouse;
            return this;
        }

        @Override
        public Beneficiary build() {
            return new Beneficiary(this);
        }

    }

}
