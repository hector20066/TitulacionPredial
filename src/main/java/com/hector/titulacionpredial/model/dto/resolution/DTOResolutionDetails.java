package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) que contiene la informacion obtenida
 * de una Resolucion.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentacion para mostrar la informacion, evitando
 * exponer directamente la entidad {@code Resolution}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOResolution} agregando información especifica
 * relacionada con el codigo y el nombre del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene logica de negocio ni reglas de validacion.
 * Su unica responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOResolutionDetails.Builder}.
 * </p>
 *
 * @author hectoracevedo
 * @since 1.0
 */
public class DTOResolutionDetails extends DTOResolution {

    private int code;
    private String beneficiaryName;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOResolutionDetails() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOResolutionDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    /**
     * Builder para la construcción fluida de instancias
     * de {@link DTOResolutionDetails}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;
        private String beneficiaryName;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOResolutionDetails}.
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOResolutionDetails build() {
            return new DTOResolutionDetails(this);
        }

    }

}
