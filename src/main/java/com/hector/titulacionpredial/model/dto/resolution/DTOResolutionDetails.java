package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionDetails extends DTOResolution {

    private int code;
    private String beneficiaryName;

    public DTOResolutionDetails() {
        super();
    }

    public DTOResolutionDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public int getCode() {
        return code;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;
        private String beneficiaryName;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        @Override
        public DTOResolutionDetails build() {
            return new DTOResolutionDetails(this);
        }

    }

}
