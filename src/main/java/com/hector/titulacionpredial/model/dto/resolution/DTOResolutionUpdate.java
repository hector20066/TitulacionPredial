package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) que contiene la informacion
 * para actualizar los datos del beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentacion a
 * la capa de persistencia para actualizar la informacion, evitando
 * exponer directamente la entidad {@code Resolution}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOResolution} agregando informacion especifica
 * relacionada con el codigo de la resolucion.
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
 * @author hectoracevedo
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
     * Builder para la construccion fluida de instancias
     * de {@link DTOResolutionUpdate}
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;

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
