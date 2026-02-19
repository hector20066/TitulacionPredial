package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionDetails extends DTOResolution {

    private LocalDate notification;
    private String fmi;
    private String notary;

    public DTOResolutionDetails() {
        super();
    }

    public DTOResolutionDetails(Builder builder) {
        super(builder);
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
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

    public LocalDate getNotification() {
        return notification;
    }

    public String getFmi() {
        return fmi;
    }

    public String getNotary() {
        return notary;
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        private LocalDate notification;
        private String fmi;
        private String notary;

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

        @Override
        public DTOResolutionDetails build() {
            return new DTOResolutionDetails(this);
        }

    }

}
