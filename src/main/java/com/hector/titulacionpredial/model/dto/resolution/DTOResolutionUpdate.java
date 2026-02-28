package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) que contiene la información
 * para actualizar los datos de una resolución.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentación a
 * la capa de persistencia para actualizar la información, evitando
 * exponer directamente la entidad {@code Resolution}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOResolution} agregando información específica
 * relacionada con el código de la resolución.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOResolution.Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOResolutionUpdate extends DTOResolution {

    private int code;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOResolutionUpdate() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOResolutionUpdate(Builder builder) {
        super(builder);
        this.code = builder.code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Builder para la construcción fluida de instancias
     * de {@link DTOResolutionUpdate}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;

        /**
         * Establece el código de la resolución a actualizar.
         *
         * @param code código de la resolución
         * @return builder actual
         */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOResolutionUpdate}
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOResolutionUpdate build() {
            return new DTOResolutionUpdate(this);
        }

    }

}
