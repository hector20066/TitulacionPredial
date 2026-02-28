package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) que contiene la información
 * para registrar un beneficiario en el sistema.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentación
 * a la capa de persistencia para guardar la información, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiary} agregando información específica
 * relacionada con el lugar de expedición, la referencia catastral
 * y datos personales.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOBeneficiaryCreate.Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryCreate extends DTOBeneficiary {

    /**
     * Cédula única del beneficiario.
     */
    protected long id;

    /**
     * Nombre completo del beneficiario.
     */
    protected String fullName;

    /**
     * Lugar de expedición.
     */
    protected String expeditionLocation;

    /**
     * Referencia catastral.
     */
    protected String cadastralReference;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiaryCreate() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOBeneficiaryCreate(AbstractBuilder<?> builder) {
        super(builder);
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.expeditionLocation = builder.expeditionLocation;
        this.cadastralReference = builder.cadastralReference;
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

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public String getCadastralReference() {
        return cadastralReference;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    /**
     * Builder genérico para la construcción fluida de instancias
     * de {@link DTOBeneficiaryCreate}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     *
     * @param <T> tipo concreto del builder
     */
    public abstract static class AbstractBuilder<T extends AbstractBuilder<T>> extends DTOBeneficiary.Builder<T> {

        private long id;
        private String fullName;
        private String expeditionLocation;
        private String cadastralReference;

        /**
         * Establece el id.
         *
         * @param id cédula del beneficiario
         * @return builder actual
         */
        public T id(long id) {
            this.id = id;
            return self();
        }

        /**
         * Establece el nombre completo.
         *
         * @param fullName nombre completo del beneficiario
         * @return builder actual
         */
        public T fullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

        /**
         * Establece el lugar de expedición.
         *
         * @param expeditionLocation lugar de expedición
         * @return builder actual
         */
        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

        /**
         * Establece la referencia catastral.
         *
         * @param cadastralReference referencia catastral
         * @return builder actual
         */
        public T cadastralReference(String cadastralReference) {
            this.cadastralReference = cadastralReference;
            return self();
        }

    }

    /**
     * Builder con implementación concreta del método {@link #build()}
     * para la creación de la instancia de {@link DTOBeneficiaryCreate}.
     */
    public static class Builder extends AbstractBuilder<Builder> {

        /**
         * Construye un nueva instancia de {@link DTOBeneficiaryCreate}
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOBeneficiaryCreate build() {
            return new DTOBeneficiaryCreate(this);
        }

    }

}
