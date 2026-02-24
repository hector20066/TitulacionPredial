package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiarySimpleDetails extends DTOBeneficiary {

    private int code;
    private long id;
    private String fullName;
    private long cadastralReference;

    public DTOBeneficiarySimpleDetails() {
        super();
    }

    public DTOBeneficiarySimpleDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.cadastralReference = builder.cadastralReference;
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

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
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

    public long getCadastralReference() {
        return cadastralReference;
    }

    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private int code;
        private long id;
        private String fullName;
        private long cadastralReference;

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

        public Builder cadastralReference(long cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        @Override
        public DTOBeneficiarySimpleDetails build() {
            return new DTOBeneficiarySimpleDetails(this);
        }

    }

}
