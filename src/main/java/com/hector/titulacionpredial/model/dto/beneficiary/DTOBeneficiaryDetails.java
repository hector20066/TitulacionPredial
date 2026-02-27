package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Data Transfer Object (DTO) que contiene la informacion obtenida
 * de un beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentacion para mostrar la informacion, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiaryCreate} agregando informacion especifica
 * relacionada con el codigo y la informacion del conyuge del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene logica de negocio ni reglas de validacion.
 * Su unica responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrón {@link DTOBeneficiaryDetails.Builder}.
 * </p>
 *
 * @author hectoracevedo
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getIdSpouse() {
        return idSpouse;
    }

    public void setIdSpouse(long idSpouse) {
        this.idSpouse = idSpouse;
    }

    public String getFullNameSpouse() {
        return fullNameSpouse;
    }

    public void setFullNameSpouse(String fullNameSpouse) {
        this.fullNameSpouse = fullNameSpouse;
    }

    public String getExpeditionLocationSpouse() {
        return expeditionLocationSpouse;
    }

    public void setExpeditionLocationSpouse(String expeditionLocationSpouse) {
        this.expeditionLocationSpouse = expeditionLocationSpouse;
    }

    public String getAddressSpouse() {
        return addressSpouse;
    }

    public void setAddressSpouse(String addressSpouse) {
        this.addressSpouse = addressSpouse;
    }

    public long getPhoneSpouse() {
        return phoneSpouse;
    }

    public void setPhoneSpouse(long phoneSpouse) {
        this.phoneSpouse = phoneSpouse;
    }

    public int getSpouseBeneficiaryCode() {
        return spouseBeneficiaryCode;
    }

    public void setSpouseBeneficiaryCode(int spouseBeneficiaryCode) {
        this.spouseBeneficiaryCode = spouseBeneficiaryCode;
    }

    /**
     * Builder para la construccion fluida de instancias
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

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder idSpouse(long idSpouse) {
            this.idSpouse = idSpouse;
            return this;
        }

        public Builder fullNameSpouse(String fullNameSpouse) {
            this.fullNameSpouse = fullNameSpouse;
            return this;
        }

        public Builder expeditionLocationSpouse(String expeditionLocationSpouse) {
            this.expeditionLocationSpouse = expeditionLocationSpouse;
            return this;
        }

        public Builder addressSpouse(String addressSpouse) {
            this.addressSpouse = addressSpouse;
            return this;
        }

        public Builder phoneSpouse(long phoneSpouse) {
            this.phoneSpouse = phoneSpouse;
            return this;
        }

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
