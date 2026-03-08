package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Data Transfer Object (DTO) that contains the information obtained
 * from a beneficiary.
 *
 * <p>
 * It is used to transport data from the persistence layer to the
 * presentation layer to display the information, avoiding directly
 * exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOBeneficiaryCreate} by adding specific information
 * related to the code and the beneficiary's spouse information.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent construction using the
 * {@link DTOBeneficiaryDetails.Builder} pattern.
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
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiaryDetails() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
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
     * Builder for the fluid construction of
     * {@link DTOBeneficiaryDetails} instances.
     *
     * <p>
     * It allows you to configure the attributes
     * before invoking {@link #build()}.
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

        @Override
        public DTOBeneficiaryDetails build() {
            return new DTOBeneficiaryDetails(this);
        }

    }

}
