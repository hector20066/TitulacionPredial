package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;
import com.hector.titulacionpredial.model.entities.Property;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionCreate extends DTOResolution {

    private long resolutionNumber;
    private LocalDate notification;
    private String fmi;
    private String notary;
    private int propertyCode;

    public DTOResolutionCreate() {
        super();
    }

    public DTOResolutionCreate(Builder builder) {
        super(builder.executory, builder.act, builder.publicWriting);
        this.resolutionNumber = builder.resolutionNumber;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
        this.propertyCode = builder.propertyCode;
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

    public void setPropertyCode(int property) {
        this.propertyCode = propertyCode;
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

    public int getPropertyCode() {
        return propertyCode;
    }

    public static class Builder {

        private long resolutionNumber;
        private LocalDate notification;
        private String fmi;
        private String notary;
        private int propertyCode;
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

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
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

        public DTOResolutionCreate build() {
            return new DTOResolutionCreate(this);
        }

    }

}
