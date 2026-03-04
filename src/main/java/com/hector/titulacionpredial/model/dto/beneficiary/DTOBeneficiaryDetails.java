package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Data Transfer Object (DTO) que contiene la información obtenida
 * de un beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentación para mostrar la información, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiaryCreate} agregando información específica
 * relacionada con el código y la información del cónyuge del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOBeneficiaryDetails.Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryDetails extends DTOBeneficiaryCreate {

    private int code;
    private long idSpouse;
    private String fullNameSpouse;
    private String expeditionLocationSpouse;
    private String addressSpouse;
    private long phoneSpouse;
    private int spouseBeneficiaryCode;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiaryDetails() {
        super();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOBeneficiaryDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.idSpouse = builder.idSpouse;
        this.fullNameSpouse = builder.fullNameSpouse;
        this.expeditionLocationSpouse = builder.expeditionLocationSpouse;
        this.addressSpouse = builder.addressSpouse;
        this.phoneSpouse = builder.phoneSpouse;
        this.spouseBeneficiaryCode = builder.spouseBeneficiaryCode;
    }

    /**
     * Obtiene el código del beneficiario.
     *
     * @return código del beneficiario
     */
    public int getCode() {
        return code;
    }

    /**
     * Establece el código del beneficiario.
     *
     * @param code código del beneficiario
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Obtiene la cédula del cónyuge.
     *
     * @return cédula del cónyuge
     */
    public long getIdSpouse() {
        return idSpouse;
    }

    /**
     * Establece la cédula del cónyuge.
     *
     * @param idSpouse cédula del cónyuge
     */
    public void setIdSpouse(long idSpouse) {
        this.idSpouse = idSpouse;
    }

    /**
     * Obtiene el nombre completo del cónyuge.
     *
     * @return nombre completo del cónyuge
     */
    public String getFullNameSpouse() {
        return fullNameSpouse;
    }

    /**
     * Establece el nombre completo del cónyuge.
     *
     * @param fullNameSpouse nombre completo del cónyuge
     */
    public void setFullNameSpouse(String fullNameSpouse) {
        this.fullNameSpouse = fullNameSpouse;
    }

    /**
     * Obtiene el lugar de expedición del cónyuge.
     *
     * @return lugar de expedición del cónyuge
     */
    public String getExpeditionLocationSpouse() {
        return expeditionLocationSpouse;
    }

    /**
     * Establece el lugar de expedición del cónyuge.
     *
     * @param expeditionLocationSpouse lugar de expedición del cónyuge
     */
    public void setExpeditionLocationSpouse(String expeditionLocationSpouse) {
        this.expeditionLocationSpouse = expeditionLocationSpouse;
    }

    /**
     * Obtiene la dirección del cónyuge.
     *
     * @return dirección del cónyuge
     */
    public String getAddressSpouse() {
        return addressSpouse;
    }

    /**
     * Establece la dirección del cónyuge.
     *
     * @param addressSpouse dirección del cónyuge
     */
    public void setAddressSpouse(String addressSpouse) {
        this.addressSpouse = addressSpouse;
    }

    /**
     * Obtiene el teléfono del cónyuge.
     *
     * @return teléfono del cónyuge
     */
    public long getPhoneSpouse() {
        return phoneSpouse;
    }

    /**
     * Establece el teléfono del cónyuge.
     *
     * @param phoneSpouse teléfono del cónyuge
     */
    public void setPhoneSpouse(long phoneSpouse) {
        this.phoneSpouse = phoneSpouse;
    }

    /**
     * Obtiene el código de beneficiario asociado al cónyuge.
     *
     * @return código de beneficiario del cónyuge
     */
    public int getSpouseBeneficiaryCode() {
        return spouseBeneficiaryCode;
    }

    /**
     * Establece el código de beneficiario asociado al cónyuge.
     *
     * @param spouseBeneficiaryCode código de beneficiario del cónyuge
     */
    public void setSpouseBeneficiaryCode(int spouseBeneficiaryCode) {
        this.spouseBeneficiaryCode = spouseBeneficiaryCode;
    }

    /**
     * Builder para la construcción fluida de instancias
     * de {@link DTOBeneficiaryDetails}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOBeneficiaryCreate.AbstractBuilder<Builder> {

        private int code;
        private long idSpouse;
        private String fullNameSpouse;
        private String expeditionLocationSpouse;
        private String addressSpouse;
        private long phoneSpouse;
        private int spouseBeneficiaryCode;

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
         * Establece la cédula del cónyuge.
         *
         * @param idSpouse cédula del cónyuge
         * @return builder actual
         */
        public Builder idSpouse(long idSpouse) {
            this.idSpouse = idSpouse;
            return this;
        }

        /**
         * Establece el nombre completo del cónyuge.
         *
         * @param fullNameSpouse nombre completo
         * @return builder actual
         */
        public Builder fullNameSpouse(String fullNameSpouse) {
            this.fullNameSpouse = fullNameSpouse;
            return this;
        }

        /**
         * Establece el lugar de expedición del cónyuge.
         *
         * @param expeditionLocationSpouse lugar de expedición
         * @return builder actual
         */
        public Builder expeditionLocationSpouse(String expeditionLocationSpouse) {
            this.expeditionLocationSpouse = expeditionLocationSpouse;
            return this;
        }

        /**
         * Establece la dirección del cónyuge.
         *
         * @param addressSpouse dirección del cónyuge
         * @return builder actual
         */
        public Builder addressSpouse(String addressSpouse) {
            this.addressSpouse = addressSpouse;
            return this;
        }

        /**
         * Establece el teléfono del cónyuge.
         *
         * @param phoneSpouse teléfono de contacto
         * @return builder actual
         */
        public Builder phoneSpouse(long phoneSpouse) {
            this.phoneSpouse = phoneSpouse;
            return this;
        }

        /**
         * Establece el código de beneficiario asociado al cónyuge.
         *
         * @param spouseBeneficiaryCode código del beneficiario
         * @return builder actual
         */
        public Builder spouseBeneficiaryCode(int spouseBeneficiaryCode) {
            this.spouseBeneficiaryCode = spouseBeneficiaryCode;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOBeneficiaryDetails}.
         *
         * @return nuevo DTO configurado
         */
        @Override
        public DTOBeneficiaryDetails build() {
            return new DTOBeneficiaryDetails(this);
        }

    }

}
