package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionDetails extends DTOResolution {

    private int code;
    private LocalDate notification;
    private String fmi;
    private String notary;
    private String beneficiaryName;

    public DTOResolutionDetails() {
        super();
    }

    public DTOResolutionDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public void setCode(int code) {
        this.code = code;
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

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public int getCode() {
        return code;
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

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;
        private LocalDate notification;
        private String fmi;
        private String notary;
        private String beneficiaryName;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

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
