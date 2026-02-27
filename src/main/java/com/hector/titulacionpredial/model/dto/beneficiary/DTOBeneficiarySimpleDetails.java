package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) que contiene un resumen de la informacion
 * del beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentación para mostrar la informacion, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiary} agregando informacion
 * relacionada con el codigo, la cedula, el nombre y la referencia
 * catastral del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene logica de negocio ni reglas de validacion.
 * Su unica responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón
 * {@link DTOBeneficiarySimpleDetails.Builder}.
 * </p>
 *
 * @author hectoracevedo
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
     * Builder para la construccion fluida de instancias
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

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

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
