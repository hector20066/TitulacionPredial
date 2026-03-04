package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

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

    /**
     * Obtiene el código interno del beneficiario.
     *
     * @return código interno
     */
    public int getCode() {
        return code;
    }

    /**
     * Establece el código interno del beneficiario.
     *
     * @param code código interno
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Obtiene el departamento asociado al beneficiario.
     *
     * @return departamento asociado
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Establece el departamento asociado al beneficiario.
     *
     * @param department departamento asociado
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Obtiene el municipio asociado al beneficiario.
     *
     * @return municipio asociado
     */
    public Municipalities getMunicipality() {
        return municipality;
    }

    /**
     * Establece el municipio asociado al beneficiario.
     *
     * @param municipality municipio asociado
     */
    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    /**
     * Obtiene la referencia catastral del beneficiario.
     *
     * @return referencia catastral
     */
    public String getCadastralReference() {
        return cadastralReference;
    }

    /**
     * Establece la referencia catastral del beneficiario.
     *
     * @param cadastralReference referencia catastral
     */
    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    /**
     * Obtiene el estado civil del beneficiario.
     *
     * @return estado civil
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
     * Obtiene la información de afectación predial.
     *
     * @return información de afectación
     */
    public String getAffectation() {
        return affectation;
    }

    /**
     * Establece la información de afectación predial.
     *
     * @param affectation información de afectación
     */
    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    /**
     * Obtiene la información de cruce del beneficiario.
     *
     * @return información de cruce
     */
    public String getCrossing() {
        return crossing;
    }

    /**
     * Establece la información de cruce del beneficiario.
     *
     * @param crossing información de cruce
     */
    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    /**
     * Obtiene la información de publicación del beneficiario.
     *
     * @return información de publicación
     */
    public String getPublication() {
        return publication;
    }

    /**
     * Establece la información de publicación del beneficiario.
     *
     * @param publication información de publicación
     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    /**
     * Obtiene el barrio de residencia del beneficiario.
     *
     * @return barrio de residencia
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Establece el barrio de residencia del beneficiario.
     *
     * @param neighborhood barrio de residencia
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Obtiene el cónyuge del beneficiario.
     *
     * @return entidad cónyuge
     */
    public Spouse getSpouse() {
        return spouse;
    }

    /**
     * Establece el cónyuge del beneficiario.
     *
     * @param spouse entidad cónyuge
     */
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

        /**
         * Establece el código del beneficiario.
         *
         * @param code código interno
         * @return builder actual
         */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Establece el departamento.
         *
         * @param department departamento asociado
         * @return builder actual
         */
        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        /**
         * Establece el municipio.
         *
         * @param municipality municipio asociado
         * @return builder actual
         */
        public Builder municipality(Municipalities municipality) {
            this.municipality = municipality;
            return this;
        }

        /**
         * Establece la referencia catastral.
         *
         * @param cadastralReference referencia catastral
         * @return builder actual
         */
        public Builder cadastralReference(String cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        /**
         * Establece el estado civil.
         *
         * @param maritalStatus estado civil del beneficiario
         * @return builder actual
         */
        public Builder maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        /**
         * Establece la afectación predial.
         *
         * @param affectation información de afectación
         * @return builder actual
         */
        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        /**
         * Establece el cruce.
         *
         * @param crossing información de cruce
         * @return builder actual
         */
        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

        /**
         * Establece la publicación.
         *
         * @param publication información de publicación
         * @return builder actual
         */
        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        /**
         * Establece el barrio.
         *
         * @param neighborhood barrio de residencia
         * @return builder actual
         */
        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        /**
         * Establece el cónyuge del beneficiario.
         *
         * @param spouse entidad cónyuge
         * @return builder actual
         */
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
