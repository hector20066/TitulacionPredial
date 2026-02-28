package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) que contiene la informacion
 * para actualizar los datos del beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentación a
 * la capa de persistencia para actualizar la información, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiary} agregando informacion especifica
 * relacionada con el código usado para identificar al beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOBeneficiaryUpdate.Builder}.
 * </p>
 *
 * @author hectoracevedo
 * @since 1.0
 */
public class DTOBeneficiaryUpdate extends DTOBeneficiary {

    private int code;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiaryUpdate() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOBeneficiaryUpdate(Builder builder) {
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
     * de {@link DTOBeneficiaryUpdate}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private int code;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOBeneficiaryUpdate}.
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOBeneficiaryUpdate build() {
            return new DTOBeneficiaryUpdate(this);
        }

    }

}
