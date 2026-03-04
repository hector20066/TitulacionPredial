package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

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
 * @author Ing. Hector Acevedo
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

    /**
     * Obtiene el departamento asociado al beneficiario.
     *
     * @return departamento del beneficiario
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Establece el departamento asociado al beneficiario.
     *
     * @param department departamento del beneficiario
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Obtiene el municipio asociado al beneficiario.
     *
     * @return municipio del beneficiario
     */
    public Municipalities getMunicipality() {
        return municipality;
    }

    /**
     * Establece el municipio asociado al beneficiario.
     *
     * @param municipality municipio del beneficiario
     */
    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    /**
     * Obtiene el barrio o sector de residencia.
     *
     * @return barrio de residencia
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Establece el barrio o sector de residencia.
     *
     * @param neighborhood barrio de residencia
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Obtiene la información sobre cruces administrativos.
     *
     * @return información de cruces administrativos
     */
    public String getCrossing() {
        return crossing;
    }

    /**
     * Establece la información sobre cruces administrativos.
     *
     * @param crossing información de cruces administrativos
     */
    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    /**
     * Obtiene la información relacionada con publicaciones oficiales.
     *
     * @return información de publicaciones oficiales
     */
    public String getPublication() {
        return publication;
    }

    /**
     * Establece la información relacionada con publicaciones oficiales.
     *
     * @param publication información de publicaciones oficiales
     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    /**
     * Obtiene el estado civil del beneficiario.
     *
     * @return estado civil del beneficiario
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Establece el estado civil del beneficiario.
     *
     * @param maritalStatus estado civil del beneficiario
     */
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Obtiene la información sobre afectaciones jurídicas.
     *
     * @return información de afectaciones jurídicas
     */
    public String getAffectation() {
        return affectation;
    }

    /**
     * Establece la información sobre afectaciones jurídicas.
     *
     * @param affectation información de afectaciones jurídicas
     */
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
         * Establece el departamento.
         *
         * @param department departamento asociado al beneficiario
         * @return builder actual
         */
        public T department(Department department) {
            this.department = department;
            return self();
        }

        /**
         * Establece el municipio.
         *
         * @param municipalities municipio asociado al beneficiario
         * @return builder actual
         */
        public T municipality(Municipalities municipalities) {
            this.municipality = municipalities;
            return self();
        }

        /**
         * Establece el barrio.
         *
         * @param neighborhood barrio de residencia
         * @return builder actual
         */
        public T neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return self();
        }

        /**
         * Establece la dirección.
         *
         * @param address dirección del beneficiario
         * @return builder actual
         */
        public T address(String address) {
            this.address = address;
            return self();
        }

        /**
         * Establece el teléfono.
         *
         * @param phone teléfono del beneficiario
         * @return builder actual
         */
        public T phone(long phone) {
            this.phone = phone;
            return self();
        }

        /**
         * Establece el cruce.
         *
         * @param crossing cruce del beneficiario
         * @return builder actual
         */
        public T crossing(String crossing) {
            this.crossing = crossing;
            return self();
        }

        /**
         * Establece la publicación.
         *
         * @param publication publicación oficial
         * @return builder actual
         */
        public T publication(String publication) {
            this.publication = publication;
            return self();
        }

        /**
         * Establece el estado civil.
         *
         * @param maritalStatus estado civil del beneficiario
         * @return builder actual
         */
        public T maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return self();
        }

        /**
         * Establece la afectación.
         *
         * @param affectation afectación del beneficiario
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
