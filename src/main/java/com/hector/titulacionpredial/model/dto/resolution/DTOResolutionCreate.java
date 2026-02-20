package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionCreate extends DTOResolution {

    private LocalDate notification;
    private String fmi;
    private String notary;
    private int propertyCode;
    private String beneficiaryName;

    public DTOResolutionCreate() {
        super();
    }

    public DTOResolutionCreate(Builder builder) {
        super(builder);
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
        this.propertyCode = builder.propertyCode;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public String getFmi() {
        return fmi;
    }

    public String getNotary() {
        return notary;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        private LocalDate notification;
        private String fmi;
        private String notary;
        private int propertyCode;
        private String beneficiaryName;

        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

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
