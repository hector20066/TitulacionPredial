package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) that represents a spouse's information
 * for system input or output operations.
 *
 * <p>
 * It is used to transport data between the presentation layer and the
 * persistence layer, avoiding directly exposing the {@code Spouse}
 * entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOBasePerson} by adding specific information related
 * to the place of issue, full name, and code of {@code Beneficiary}.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluid construction using the {@link Builder} pattern.
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
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOSpouse() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
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
     * Builder for seamless construction of {@link DTOSpouse} instances
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
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

        public DTOSpouse build() {
            return new DTOSpouse(this);
        }

    }

}
