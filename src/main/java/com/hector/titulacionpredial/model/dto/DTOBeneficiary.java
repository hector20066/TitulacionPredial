package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.MaritalStatus;

/**
 * Data Transfer Object (DTO) that represents the information of a
 * beneficiary for system entry or exit operations.
 *
 * <p>
 * It is used to transport data between the presentation layer and
 * the persistence layer, avoiding directly exposing the
 * {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOBasePerson} by adding specific information
 * related to location, marital status, and administrative data.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluid construction using the {@link Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiary extends DTOBasePerson {

    /**
     * code of the beneficiaries.
     */
    protected String codeBeneficiaries;

    /**
     * marital status of the beneficiary.
     */
    protected MaritalStatus maritalStatus;

    /**
     * Information on legal implications.
     */
    protected String affectation;

    /**
     * Empty constructor required for serialization
     * or mapping frameworks.
     */
    public DTOBeneficiary() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    protected DTOBeneficiary(Builder<?> builder) {
        super(builder);
        this.codeBeneficiaries = builder.codeBeneficiaries;
        this.maritalStatus = builder.maritalStatus;
        this.affectation = builder.affectation;
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

    /**
     * Generic builder for fluid building of
     * {@link DTOBeneficiary} instances.
     *
     * <p>
     * It allows you to configure the attributes
     * before invoking {@link #build()}.
     * </p>
     *
     * @param <T> specific type of builder
     */
    public static class Builder<T extends Builder<T>> extends DTOBasePerson.Builder<T> {

        private String codeBeneficiaries;
        private MaritalStatus maritalStatus;
        private String affectation;

        /**
         * Returns the concrete instance of the builder.
         *
         * @return typed instance of the builder
         */
        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        /**
         * It establishes code of the beneficiaries.
         *
         * @param codeBeneficiaries marital status of the beneficiary
         * @return current builder
         */
        public T codeBeneficiaries(String codeBeneficiaries) {
            this.codeBeneficiaries = codeBeneficiaries;
            return self();
        }

        /**
         * It establishes marital status.
         *
         * @param maritalStatus marital status of the beneficiary
         * @return current builder
         */
        public T maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return self();
        }

        /**
         * Establish the impact.
         *
         * @param affectation beneficiary impact
         * @return current builder
         */
        public T affectation(String affectation) {
            this.affectation = affectation;
            return self();
        }

        /**
         * Create a new instance of {@link DTOBeneficiary}.
         *
         * @return new DTO configured
         */
        public DTOBeneficiary build() {
            return new DTOBeneficiary(this);
        }

    }

}
