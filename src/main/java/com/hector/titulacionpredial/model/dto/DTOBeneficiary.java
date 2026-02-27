package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.*;

/**
 * Data Transfer Object (DTO) que representa la información
 * de un beneficiario para operaciones de entrada o salida
 * del sistema.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentación y
 * la capa de persistencia, evitando exponer directamente la entidad
 * {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBasePerson} agregando información específica
 * relacionada con ubicación, estado civil y datos administrativos.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link Builder}.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiary extends DTOBasePerson {

    /**
     * Departamento asociado al beneficiario.
     */
    protected Department department;

    /**
     * Municipio asociado al beneficiario.
     */
    protected Municipalities municipality;

    /**
     * Barrio o sector de residencia.
     */
    protected String neighborhood;

    /**
     * Información sobre cruces administrativos.
     */
    protected String crossing;

    /**
     * Información relacionada con publicaciones oficiales.
     */
    protected String publication;

    /**
     * Estado civil del beneficiario.
     */
    protected MaritalStatus maritalStatus;

    /**
     * Información sobre afectaciones jurídicas.
     */
    protected String affectation;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiary() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    protected DTOBeneficiary(Builder<?> builder) {
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

    /**
     * Builder genérico para la construcción fluida de instancias
     * de {@link DTOBeneficiary}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     *
     * @param <T> tipo concreto del builder
     */
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

        /**
         * Devuelve la instancia concreta del builder.
         *
         * @return instancia tipada del builder
         */
        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        /**
         * Establecer departamento
         *
         * @param department departamento asociado al beneficiario
         * @return builder actual
         */
        public T department(Department department) {
            this.department = department;
            return self();
        }

        /**
         * Establecer Municipio
         *
         * @param municipalities municipio asociado al beneficiario
         * @return builder actual
         */
        public T municipality(Municipalities municipalities) {
            this.municipality = municipalities;
            return self();
        }

        /**
         * Establecer barrio
         *
         * @param neighborhood barrio de residencia
         * @return builder actual
         */
        public T neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return self();
        }

        /**
         * Establecer direccion
         *
         * @param address direccion del beneficiario
         * @return builder actual
         */
        public T address(String address) {
            this.address = address;
            return self();
        }

        /**
         * Establecer telefono
         *
         * @param phone telefono del beneficiario
         * @return builder actual
         */
        public T phone(long phone) {
            this.phone = phone;
            return self();
        }

        /**
         * Establecer cruce
         *
         * @param crossing cruce
         * @return
         */
        public T crossing(String crossing) {
            this.crossing = crossing;
            return self();
        }

        /**
         * Establecer publicacion
         *
         * @param publication publicacion
         * @return builder actual
         */
        public T publication(String publication) {
            this.publication = publication;
            return self();
        }

        /**
         * Establecer el estado civil
         *
         * @param maritalStatus estado civil del beneficiario
         * @return builder actual
         */
        public T maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return self();
        }

        /**
         * Establecer afectacion
         *
         * @param affectation afectacion del beneficiario
         * @return builder actual
         */
        public T affectation(String affectation) {
            this.affectation = affectation;
            return self();
        }

        /**
         * Construye una nueva instancia de {@link DTOBeneficiary}.
         *
         * @return nuevo DTO configurado
         */
        public DTOBeneficiary build() {
            return new DTOBeneficiary(this);
        }

    }

}
