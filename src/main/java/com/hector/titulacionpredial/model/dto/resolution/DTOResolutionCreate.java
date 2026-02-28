package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) que contiene la informacion obtenida
 * de una Resolucion.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentacion
 * a la capa de persistencia para guardar la informacion, evitando
 * exponer directamente la entidad {@code Resolution}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOResolution} agregando informacion especifica
 * relacionada con el codigo de la propiedad y el nombre del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene logica de negocio ni reglas de validacion.
 * Su unica responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construccion fluida mediante el patron {@link DTOResolutionCreate.Builder}.
 * </p>
 *
 * @author hectoracevedo
 * @since 1.0
 */
public class DTOResolutionCreate extends DTOResolution {

    private int propertyCode;
    private String beneficiaryName;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOResolutionCreate() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOResolutionCreate(Builder builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Builder para la construccion fluida de instancias
     * de {@link DTOResolutionCreate}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int propertyCode;
        private String beneficiaryName;

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOResolutionCreate}.
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOResolutionCreate build() {
            return new DTOResolutionCreate(this);
        }

    }

}
