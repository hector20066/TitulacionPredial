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

    public DTOResolutionCreate() {
        super();
    }

    public DTOResolutionCreate(Builder builder) {
        super(builder);
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
        this.propertyCode = builder.propertyCode;
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

    public static class Builder extends DTOResolution.Builder<Builder> {

        private LocalDate notification;
        private String fmi;
        private String notary;
        private int propertyCode;

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

        @Override
        public DTOResolutionCreate build() {
            return new DTOResolutionCreate(this);
        }

    }

}
