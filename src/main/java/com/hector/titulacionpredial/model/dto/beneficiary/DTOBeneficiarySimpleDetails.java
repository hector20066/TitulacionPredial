package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) que contiene un resumen de la información
 * del beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentación para mostrar la información, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiary} agregando información
 * relacionada con el código, la cédula, el nombre y la referencia
 * catastral del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón
 * {@link DTOBeneficiarySimpleDetails.Builder}.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiarySimpleDetails extends DTOBeneficiary {

    private int code;
    private long id;
    private String fullName;
    private String cadastralReference;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiarySimpleDetails() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOBeneficiarySimpleDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.cadastralReference = builder.cadastralReference;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCadastralReference() {
        return cadastralReference;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    /**
     * Builder para la construcción fluida de instancias
     * de {@link DTOBeneficiarySimpleDetails}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private int code;
        private long id;
        private String fullName;
        private String cadastralReference;

        /**
         * Establece el código del beneficiario.
         *
         * @param code código del beneficiario
         * @return builder actual
         */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Establece la cédula del beneficiario.
         *
         * @param id cédula del beneficiario
         * @return builder actual
         */
        public Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Establece el nombre completo del beneficiario.
         *
         * @param fullName nombre completo
         * @return builder actual
         */
        public Builder fullName(String fullName) {
            this.fullName = fullName;
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
         * Construye una nueva instancia de {@link DTOBeneficiarySimpleDetails}.
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOBeneficiarySimpleDetails build() {
            return new DTOBeneficiarySimpleDetails(this);
        }

    }

}
