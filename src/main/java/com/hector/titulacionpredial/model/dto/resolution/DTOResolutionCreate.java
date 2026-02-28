package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) que contiene la información obtenida
 * de una resolución.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentación
 * a la capa de persistencia para guardar la información, evitando
 * exponer directamente la entidad {@code Resolution}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOResolution} agregando información específica
 * relacionada con el código de la propiedad y el nombre del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOResolutionCreate.Builder}.
 * </p>
 *
 * @author Hector Acevedo
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
     * Builder para la construcción fluida de instancias
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

        /**
         * Establece el código del predio asociado.
         *
         * @param propertyCode código del predio
         * @return builder actual
         */
        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        /**
         * Establece el nombre del beneficiario.
         *
         * @param beneficiaryName nombre completo del beneficiario
         * @return builder actual
         */
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
