package com.hector.titulacionpredial.model.entities;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class Resolution {

    private int code;
    private long resolutionNumber;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private String notary;
    private Property property;
    private Beneficiary beneficiary;

    public Resolution() {

    }

    public Resolution(Builder builder) {
        this.code = builder.code;
        this.resolutionNumber = builder.resolutionNumber;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.property = builder.property;
        this.beneficiary = builder.beneficiary;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public int getCode() {
        return code;
    }

    public long getResolutionNumber() {
        return resolutionNumber;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public String getFmi() {
        return fmi;
    }

    public String getAct() {
        return act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public String getNotary() {
        return notary;
    }

    public Property getProperty() {
        return property;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    @Override
    public String toString() {
        return  "Code= " + code +
                "\nResolution Number= " + resolutionNumber +
                "\nNotification= " + notification +
                "\nExecutory= " + executory +
                "\nFMI= " + fmi +
                "\nAct= " + act +
                "\nPublicWriting= " + publicWriting +
                "\nNotary= " + notary +
                "\nProperty= " + property +
                "\nBeneficiary= " + beneficiary;
    }

    public static class Builder {

        private int code;
        private long resolutionNumber;
        private LocalDate notification;
        private LocalDate executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private Property property;
        private Beneficiary beneficiary;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return this;
        }

        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

        public Builder executory(LocalDate executory) {
            this.executory = executory;
            return this;
        }

        public Builder fmi(String fmi) {
            this.fmi = fmi;
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

        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        public Builder property(Property property) {
            this.property = property;
            return this;
        }

        public Builder beneficiary(Beneficiary beneficiary) {
            this.beneficiary = beneficiary;
            return this;
        }

        public Resolution build() {
            return new Resolution(this);
        }

    }

}
