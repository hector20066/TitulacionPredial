package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) que representa la información
 * de un cónyuge para operaciones de entrada o salida
 * del sistema.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentación
 * y la capa de persistencia, evitando exponer directamente la entidad
 * {@code Spouse}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBasePerson} agregando información específica
 * relacionada con el lugar de expedición, el nombre completo y el
 * código de {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOSpouse extends DTOBasePerson {

    private long id;
    private String fullName;
    private String expeditionLocation;
    private int beneficiaryCode;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOSpouse() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOSpouse(Builder builder) {
        super(builder.address, builder.phone);

        this.id = builder.id;
        this.fullName = builder.fullName;
        this.expeditionLocation = builder.expeditionLocation;
        this.beneficiaryCode = builder.beneficiaryCode;
    }

    /**
     * Obtiene el identificador del cónyuge.
     *
     * @return cédula del cónyuge
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el identificador del cónyuge.
     *
     * @param id cédula del cónyuge
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del cónyuge.
     *
     * @return nombre completo
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Establece el nombre completo del cónyuge.
     *
     * @param fullName nombre completo
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Obtiene el lugar de expedición del documento.
     *
     * @return lugar de expedición
     */
    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    /**
     * Establece el lugar de expedición del documento.
     *
     * @param expeditionLocation lugar de expedición
     */
    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    /**
     * Obtiene el código del beneficiario asociado.
     *
     * @return código del beneficiario
     */
    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

    /**
     * Establece el código del beneficiario asociado.
     *
     * @param beneficiaryCode código del beneficiario
     */
    public void setBeneficiaryCode(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    /**
     * Builder para la construcción fluida de instancias de {@link DTOSpouse}
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder {

        private long id;
        private String fullName;
        private String expeditionLocation;
        private String address;
        private long phone;
        private int beneficiaryCode;

        /**
         * Establece el id del cónyuge.
         *
         * @param id cédula del cónyuge
         * @return builder actual
         */
        public Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Establece el nombre completo.
         *
         * @param fullName nombre completo del cónyuge
         * @return builder actual
         */
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        /**
         * Establece el lugar de expedición.
         *
         * @param expeditionLocation lugar de expedición
         * @return builder actual
         */
        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        /**
         * Establece la dirección.
         *
         * @param address dirección del cónyuge
         * @return builder actual
         */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * Establece el teléfono.
         *
         * @param phone teléfono de contacto
         * @return builder actual
         */
        public Builder phone(long phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Establece el código del beneficiario asociado.
         *
         * @param beneficiaryCode código del beneficiario
         * @return builder actual
         */
        public Builder beneficiaryCode(int beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOSpouse}.
         *
         * @return nuevo DTO configurado
         */
        public DTOSpouse build() {
            return new DTOSpouse(this);
        }

    }

}
