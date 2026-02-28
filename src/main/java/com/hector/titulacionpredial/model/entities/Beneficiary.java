package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.*;

/**
 * Entidad de dominio que representa un Beneficiario dentro del sistema.
 *
 * <p>
 * Extiende {@link Person} agregando información específica
 * relacionada con el proceso de titulación, como:
 * </p>
 * <ul>
 *     <li>Código interno del beneficiario.</li>
 *     <li>Ubicación geográfica (departamento y municipio).</li>
 *     <li>Referencia catastral asociada.</li>
 *     <li>Estado civil.</li>
 *     <li>Información jurídica y administrativa complementaria.</li>
 * </ul>
 *
 * <p>
 * Esta entidad forma parte del modelo de dominio y es
 * persistida en la base de datos.
 * </p>
 *
 * <p>
 * La construcción de instancias se soporta mediante el patrón
 * {@link Builder}, permitiendo herencia fluida desde {@link Person.Builder}.
 * </p>
 *
 * @author Hector Acevedo
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
     * Constructor vacío requerido para frameworks de persistencia
     * o mecanismos basados en reflexión.
     */
    public Beneficiary() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
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
     * Devuelve una representación textual del beneficiario,
     * incluyendo los atributos heredados y específicos.
     *
     * @return descripción formateada del beneficiario
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
     * Builder concreto para la construcción fluida de instancias
     * de {@link Beneficiary}.
     *
     * <p>
     * Extiende {@link Person.Builder} para permitir la configuración
     * de atributos heredados y específicos en una misma cadena fluida.
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

        /**
         * Construye una nueva instancia de {@link Beneficiary}.
         *
         * @return beneficiario completamente configurado
         */
        @Override
        public Beneficiary build() {
            return new Beneficiary(this);
        }

    }

}
