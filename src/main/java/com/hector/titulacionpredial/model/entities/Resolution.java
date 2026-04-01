package com.hector.titulacionpredial.model.entities;

import java.time.LocalDate;

/**
 * Domain entity that represents an administrative resolution
 * within the land titling system.
 *
 * <p>
 * A resolution formalizes a legal act or procedure applied to
 * a {@link Property}, and may involve one or more
 * {@link Beneficiary}.
 * </p>
 *
 * <p>
 * This entity allows maintaining traceability and history of
 * the processes carried out on a property.
 * </p>
 *
 * <p>
 * Main features:
 * </p>
 * <ul>
 *     <li>It has its own identity through the attribute {@code code}.</li>
 *     <li>It is associated with a {@link Property} (many-to-one relationship).</li>
 *     <li>It can be associated with a specific {@link Beneficiary}.</li>
 *     <li>It contains key dates such as notification and execution.</li>
 *     <li>It is part of the persistent model of the system.</li>
 *     <li>It supports building using the {@link Builder} pattern.</li>
 * </ul>
 *
 * <p>
 * Its life cycle is independent of the property, but conceptually
 * it depends on its existence.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
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

    /**
     * Empty constructor required for persistence frameworks
     * or reflection mechanisms.
     */
    public Resolution() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder step-by-step constructor instance
     */
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public String getFmi() {
        return fmi;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    /**
     * Textual representation of the entity.
     *
     * @return formatted description of the main attributes
     */
    @Override
    public String toString() {
        return "Code= " + code +
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

    /**
     * Builder for controlled construction of {@link Resolution}
     * instances.
     *
     * <p>
     * It allows you to smoothly configure the property attributes
     * before its final creation using {@link #build()}.
     * </p>
     *
     * <p>
     * It does not perform automatic validations such rules must be
     * guaranteed in the service layer or added explicitly.
     * </p>
     */
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
