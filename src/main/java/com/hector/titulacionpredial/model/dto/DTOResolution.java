package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) that represents the information of a
 * resolution for input or output operations of the system.
 *
 * <p>
 * It is used to transport data between the presentation layer and
 * the persistence layer, avoiding directly exposing the
 * {@code Resolution} entity.
 * </p>
 *
 * <p>
 * It contains the information necessary for a resolution, such as the
 * resolution number and the information it will contain.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOResolution {

    /**
     * Unique resolution number.
     */
    protected long resolutionNumber;

    /**
     * Date of execution.
     */
    protected LocalDate executory;

    /**
     * Process description.
     */
    protected String act;

    /**
     * Public deed.
     */
    protected String publicWriting;

    /**
     * Date on which the resolution is generated.
     */
    protected LocalDate notification;

    /**
     * Real Estate Registration Folio.
     */
    protected String fmi;

    /**
     * Notary where the resolution is executed.
     */
    protected String notary;

    /**
     * Empty constructor required for serialization or automatic
     * mapping frameworks.
     */
    public DTOResolution() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOResolution(Builder<?> builder) {
        this.resolutionNumber = builder.resolutionNumber;
        this.executory = builder.executory;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
    }

    /**     * get resolution number.     * @return the get resolution number     */
    public long getResolutionNumber() {
        return resolutionNumber;
    }

    /**     * set resolution number.     * @param resolutionNumber the resolution number     */
    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    /**     * get executory.     * @return the get executory     */
    public LocalDate getExecutory() {
        return executory;
    }

    /**     * set executory.     * @param executory the executory     */
    public void setExecutory(LocalDate executory) {
        this.executory = executory;
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

    /**     * get notification.     * @return the get notification     */
    public LocalDate getNotification() {
        return notification;
    }

    /**     * set notification.     * @param notification the notification     */
    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    /**     * get fmi.     * @return the get fmi     */
    public String getFmi() {
        return fmi;
    }

    /**     * set fmi.     * @param fmi the fmi     */
    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    /**     * get notary.     * @return the get notary     */
    public String getNotary() {
        return notary;
    }

    /**     * set notary.     * @param notary the notary     */
    public void setNotary(String notary) {
        this.notary = notary;
    }

    /**
     * Generic builder for fluid building of
     * {@link DTOResolution} instances.
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     *
     * @param <T> specific type of builder
     */
    public static class Builder<T extends Builder<T>> {

        private long resolutionNumber;
        private LocalDate executory;
        private String act;
        private String publicWriting;
        private LocalDate notification;
        private String fmi;
        private String notary;

        /**
         * Returns the concrete instance of the builder.
         *
         * @return typed instance of the builder
         */
        @SuppressWarnings("unchecked")
    /**     * self.     * @return the self     */
        protected T self() {
            return (T) this;
        }

        /**
         * State the resolution number.
         *
         * @param resolutionNumber resolution number
         * @return current builder
         */
        public T resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return self();
        }

        /**
         * It establishes the execution.
         *
         * @param executory date of the execution
         * @return current builder
         */
        public T executory(LocalDate executory) {
            this.executory = executory;
            return self();
        }

        /**
         * Establish the act.
         *
         * @param act act of execution
         * @return current builder
         */
        public T act(String act) {
            this.act = act;
            return self();
        }

        /**
         * Establish the public deed.
         *
         * @param publicWriting public deed
         * @return current builder
         */
        public T publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return self();
        }

        /**
         * Set the notification date.
         *
         * @param notification notification date
         * @return current builder
         */
        public T notification(LocalDate notification) {
            this.notification = notification;
            return self();
        }

        /**
         * Establishes the Real Estate Registration Folio.
         *
         * @param fmi Real Estate Registration Folio
         * @return current builder
         */
        public T fmi(String fmi) {
            this.fmi = fmi;
            return self();
        }

        /**
         * The notary establishes.
         *
         * @param notary notary
         * @return current builder
         */
        public T notary(String notary) {
            this.notary = notary;
            return self();
        }

        /**
         * Build a new instance of {@link DTOResolution}.
         *
         * @return new DTO configured
         */
        public DTOResolution build() {
            return new DTOResolution(this);
        }

    }

}
