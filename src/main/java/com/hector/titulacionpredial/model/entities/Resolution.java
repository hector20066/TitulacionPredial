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

    /**     * get code.     * @return the get code     */
    public int getCode() {
        return code;
    }

    /**     * set code.     * @param code the code     */
    public void setCode(int code) {
        this.code = code;
    }

    /**     * get resolution number.     * @return the get resolution number     */
    public long getResolutionNumber() {
        return resolutionNumber;
    }

    /**     * set resolution number.     * @param resolutionNumber the resolution number     */
    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    /**     * get notification.     * @return the get notification     */
    public LocalDate getNotification() {
        return notification;
    }

    /**     * set notification.     * @param notification the notification     */
    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    /**     * get executory.     * @return the get executory     */
    public LocalDate getExecutory() {
        return executory;
    }

    /**     * set executory.     * @param executory the executory     */
    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    /**     * get fmi.     * @return the get fmi     */
    public String getFmi() {
        return fmi;
    }

    /**     * set fmi.     * @param fmi the fmi     */
    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    /**     * get act.     * @return the get act     */
    public String getAct() {
        return act;
    }

    /**     * set act.     * @param act the act     */
    public void setAct(String act) {
        this.act = act;
    }

    /**     * get public writing.     * @return the get public writing     */
    public String getPublicWriting() {
        return publicWriting;
    }

    /**     * set public writing.     * @param publicWriting the public writing     */
    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    /**     * get notary.     * @return the get notary     */
    public String getNotary() {
        return notary;
    }

    /**     * set notary.     * @param notary the notary     */
    public void setNotary(String notary) {
        this.notary = notary;
    }

    /**     * get property.     * @return the get property     */
    public Property getProperty() {
        return property;
    }

    /**     * set property.     * @param property the property     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**     * get beneficiary.     * @return the get beneficiary     */
    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    /**     * set beneficiary.     * @param beneficiary the beneficiary     */
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

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

    /**     * resolution number.     * @param resolutionNumber the resolution number     * @return the resolution number     */
        public Builder resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return this;
        }

    /**     * notification.     * @param notification the notification     * @return the notification     */
        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

    /**     * executory.     * @param executory the executory     * @return the executory     */
        public Builder executory(LocalDate executory) {
            this.executory = executory;
            return this;
        }

    /**     * fmi.     * @param fmi the fmi     * @return the fmi     */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

    /**     * act.     * @param act the act     * @return the act     */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

    /**     * public writing.     * @param publicWriting the public writing     * @return the public writing     */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

    /**     * notary.     * @param notary the notary     * @return the notary     */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

    /**     * property.     * @param property the property     * @return the property     */
        public Builder property(Property property) {
            this.property = property;
            return this;
        }

    /**     * beneficiary.     * @param beneficiary the beneficiary     * @return the beneficiary     */
        public Builder beneficiary(Beneficiary beneficiary) {
            this.beneficiary = beneficiary;
            return this;
        }

    /**     * build.     * @return the build     */
        public Resolution build() {
            return new Resolution(this);
        }

    }

}
