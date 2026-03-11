package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

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
     * Department associated with the beneficiary.
     */
    protected Department department;

    /**
     * Municipality associated with the beneficiary.
     */
    protected Municipalities municipality;

    /**
     * Neighborhood or area of residence.
     */
    protected String neighborhood;

    /**
     * Information on administrative crossings.
     */
    protected String crossing;

    /**
     * Information related to official publications.
     */
    protected String publication;

    /**
     * marital status of the beneficiary.
     */
    protected MaritalStatus maritalStatus;

    /**
     * Information on legal implications.
     */
    protected String affectation;

    /**
     * Cadastral reference associated with the beneficiary
     */
    protected String cadastralRef;

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
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
        this.maritalStatus = builder.maritalStatus;
        this.affectation = builder.affectation;
        this.cadastralRef = builder.cadastralRef;
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

    public String getCadastralRef() {
        return cadastralRef;
    }

    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
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

        private Department department;
        private Municipalities municipality;
        private String neighborhood;
        private String crossing;
        private String publication;
        private MaritalStatus maritalStatus;
        private String affectation;
        private String cadastralRef;

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
         * Establish the department.
         *
         * @param department department associated with the beneficiary
         * @return current builder
         */
        public T department(Department department) {
            this.department = department;
            return self();
        }

        /**
         * The municipality establishes this.
         *
         * @param municipalities municipality associated with the beneficiary
         * @return current builder
         */
        public T municipality(Municipalities municipalities) {
            this.municipality = municipalities;
            return self();
        }

        /**
         * Establish the neighborhood.
         *
         * @param neighborhood residential neighborhood
         * @return current builder
         */
        public T neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return self();
        }

        /**
         * Establish the crossing.
         *
         * @param crossing beneficiary crossing
         * @return current builder
         */
        public T crossing(String crossing) {
            this.crossing = crossing;
            return self();
        }

        /**
         * Establish the publication.
         *
         * @param publication official publication
         * @return current builder
         */
        public T publication(String publication) {
            this.publication = publication;
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
         * The cadastral reference establishes this
         *
         * @param cadastralRef cadastral reference associated with the beneficiary
         * @return current builder
         */
        public T cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
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
