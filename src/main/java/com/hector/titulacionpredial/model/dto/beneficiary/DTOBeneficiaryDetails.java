package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryDetails extends DTOBeneficiary {

    private int code;
    private String fullName;
    private long id;
    private long cadastralReference;
    private String expeditionLocation;

    public DTOBeneficiaryDetails() {
        super();
    }

    public DTOBeneficiaryDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.fullName = builder.fullName;
        this.id = builder.id;
        this.cadastralReference = builder.cadastralReference;
        this.expeditionLocation = builder.expeditionLocation;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public int getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public long getId() {
        return id;
    }

    public long getCadastralReference() {
        return cadastralReference;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private int code;
        private String fullName;
        private long id;
        private long cadastralReference;
        private String expeditionLocation;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder cadastralReference(long cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        @Override
        public DTOBeneficiaryDetails build() {
            return new DTOBeneficiaryDetails(this);
        }

    }

}
