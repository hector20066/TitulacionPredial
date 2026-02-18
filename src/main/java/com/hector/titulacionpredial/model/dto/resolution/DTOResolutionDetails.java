package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionDetails extends DTOResolution {

    private long resolutionNumber;
    private LocalDate notification;
    private String fmi;
    private String notary;

    public DTOResolutionDetails() {

    }

    public DTOResolutionDetails(Builder builder) {
        super(builder.executory, builder.act, builder.publicWriting);
        this.resolutionNumber = builder.resolutionNumber;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
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

    public long getResolutionNumber() {
        return resolutionNumber;
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

    public static class Builder {

        private long resolutionNumber;
        private LocalDate notification;
        private String fmi;
        private String notary;
        private LocalDate executory;
        private String act;
        private String publicWriting;

        public Builder resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
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

        public Builder executory(LocalDate executory) {
            this.executory = executory;
            return this;
        }

        public Builder act(String act) {
            this.act = act;
            return this;
        }

        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        public DTOResolutionDetails build() {
            return new DTOResolutionDetails(this);
        }

    }

}
