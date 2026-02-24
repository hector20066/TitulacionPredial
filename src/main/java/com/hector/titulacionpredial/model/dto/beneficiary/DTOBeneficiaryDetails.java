package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryDetails extends DTOBeneficiaryCreate {

    private int code;
    private long idSpouse;
    private String fullNameSpouse;
    private String expeditionLocationSpouse;
    private String addressSpouse;
    private long phoneSpouse;
    private int spouseBeneficiaryCode;

    public DTOBeneficiaryDetails() {
        super();
    }

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

    public void setCode(int code) {
        this.code = code;
    }

    public void setIdSpouse(long idSpouse) {
        this.idSpouse = idSpouse;
    }

    public void setFullNameSpouse(String fullNameSpouse) {
        this.fullNameSpouse = fullNameSpouse;
    }

    public void setExpeditionLocationSpouse(String expeditionLocationSpouse) {
        this.expeditionLocationSpouse = expeditionLocationSpouse;
    }

    public void setAddressSpouse(String addressSpouse) {
        this.addressSpouse = addressSpouse;
    }

    public void setPhoneSpouse(long phoneSpouse) {
        this.phoneSpouse = phoneSpouse;
    }

    public void setSpouseBeneficiaryCode(int spouseBeneficiaryCode) {
        this.spouseBeneficiaryCode = spouseBeneficiaryCode;
    }

    public int getCode() {
        return code;
    }

    public long getIdSpouse() {
        return idSpouse;
    }

    public String getFullNameSpouse() {
        return fullNameSpouse;
    }

    public String getExpeditionLocationSpouse() {
        return expeditionLocationSpouse;
    }

    public String getAddressSpouse() {
        return addressSpouse;
    }

    public long getPhoneSpouse() {
        return phoneSpouse;
    }

    public int getSpouseBeneficiaryCode() {
        return spouseBeneficiaryCode;
    }

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
