package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionCreate extends DTOResolution {

    private int propertyCode;
    private String beneficiaryName;

    public DTOResolutionCreate() {
        super();
    }

    public DTOResolutionCreate(Builder builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        private int propertyCode;
        private String beneficiaryName;

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        @Override
        public DTOResolutionCreate build() {
            return new DTOResolutionCreate(this);
        }

    }

}
