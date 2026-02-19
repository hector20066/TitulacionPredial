package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.enums.Municipalities;

public class DTOBeneficiarySimpleDetails {

    private int code;
    private long id;
    private String fullName;
    private long phone;
    private long cadastralReference;
    private Municipalities municipality;
    private String address;

    public DTOBeneficiarySimpleDetails() {

    }

    public DTOBeneficiarySimpleDetails(Builder builder) {
        this.code = builder.code;
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.phone = builder.phone;
        this.cadastralReference = builder.cadastralReference;
        this.municipality = builder.municipality;
        this.address = builder.address;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public long getPhone() {
        return phone;
    }

    public long getCadastralReference() {
        return cadastralReference;
    }

    public Municipalities getMunicipality() {
        return municipality;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {

        private int code;
        private long id;
        private String fullName;
        private long phone;
        private long cadastralReference;
        private Municipalities municipality;
        private String address;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder phone(long phone) {
            this.phone = phone;
            return this;
        }

        public Builder cadastralReference(long cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        public Builder municipality(Municipalities municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public DTOBeneficiarySimpleDetails build() {
            return new DTOBeneficiarySimpleDetails(this);
        }

    }

}
