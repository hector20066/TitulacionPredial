package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) que representa la información
 * de un conjugue para operaciones de entrada o salida
 * del sistema.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentacion
 * y la capa de persistencia, evitando exponer directamente la entidad
 * {@code Spouse}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBasePerson} agregando informacion especifica
 * relacionada con la fecha de expidicion, el nombre completo y el
 * código de {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patrin {@link Builder}
 * </p>
 *
 * @author hectoracevedo
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

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

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

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(long phone) {
            this.phone = phone;
            return this;
        }

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
