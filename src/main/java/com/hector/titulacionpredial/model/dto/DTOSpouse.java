package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOSpouse extends DTOBasePerson {

    private long id;
    private String fullName;
    private String expeditionLocation;
    private int beneficiaryCode;

    public DTOSpouse() {

    }

    public DTOSpouse(Builder builder) {
        super(builder.address, builder.phone);

        this.id = builder.id;
        this.fullName = builder.fullName;
        this.expeditionLocation = builder.expeditionLocation;
        this.beneficiaryCode = builder.beneficiaryCode;
    }

    public void setId(long id) {
            this.id = id;
    }

    public void setFullName(String fullName) {
            this.fullName = fullName;
    }

    public void setExpeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
    }

    public void setBeneficiaryCode(int beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
    }

    public long getId() {
            return id;
        }

    public String getFullName() {
            return fullName;
    }

    public String getExpeditionLocation() {
            return expeditionLocation;
    }

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

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
