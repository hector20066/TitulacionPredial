package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.MaritalStatus;

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
 *     <li>Marital status.</li>
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
    private String codeBeneficiaries;
    private MaritalStatus maritalStatus;
    private String affectation;
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
        this.codeBeneficiaries = builder.codeBeneficiaries;
        this.maritalStatus = builder.maritalStatus;
        this.affectation = builder.affectation;
        this.spouse = builder.spouse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeBeneficiaries() {
        return codeBeneficiaries;
    }

    public void setCodeBeneficiaries(String codeBeneficiaries) {
        this.codeBeneficiaries = codeBeneficiaries;
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
                "\nCode Beneficiaries= " + codeBeneficiaries +
                "\nMaritalStatus= " + maritalStatus +
                "\nAffectation= " + affectation;
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
        private String codeBeneficiaries;
        private MaritalStatus maritalStatus;
        private String affectation;
        private Spouse spouse;

        /**
         * Set the beneficiary code.
         *
         * @param code the unique beneficiary identifier
         * @return this builder instance for chaining
         */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Set the beneficiary code identifier string.
         *
         * @param codeBeneficiaries the beneficiary code string
         * @return this builder instance for chaining
         */
        public Builder codeBeneficiaries(String codeBeneficiaries) {
            this.codeBeneficiaries = codeBeneficiaries;
            return this;
        }

        /**
         * Set the marital status.
         *
         * @param maritalStatus the marital status enumeration
         * @return this builder instance for chaining
         */
        public Builder maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        /**
         * Set the affectation information.
         *
         * @param affectation the affectation description
         * @return this builder instance for chaining
         */
        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        /**
         * Set the spouse information.
         *
         * @param spouse the spouse entity
         * @return this builder instance for chaining
         */
        public Builder spouse(Spouse spouse) {
            this.spouse = spouse;
            return this;
        }

        /**
         * Build and return the final {@link Beneficiary} instance.
         *
         * @return constructed beneficiary object
         */
        @Override
        public Beneficiary build() {
            return new Beneficiary(this);
        }

    }

}
