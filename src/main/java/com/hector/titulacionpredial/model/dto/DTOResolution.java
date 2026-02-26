package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolution {

    protected long resolutionNumber;
    protected LocalDate executory;
    protected String act;
    protected String publicWriting;
    protected LocalDate notification;
    protected String fmi;
    protected String notary;

    public DTOResolution() {

    }

    public DTOResolution(Builder<?> builder) {
        this.resolutionNumber = builder.resolutionNumber;
        this.executory = builder.executory;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
    }

    public long getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
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

    public LocalDate getNotification() {
        return notification;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public String getFmi() {
        return fmi;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public static class Builder<T extends Builder<T>> {

        private long resolutionNumber;
        private LocalDate executory;
        private String act;
        private String publicWriting;
        private LocalDate notification;
        private String fmi;
        private String notary;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return self();
        }

        public T executory(LocalDate executory) {
            this.executory = executory;
            return self();
        }

        public T act(String act) {
            this.act = act;
            return self();
        }

        public T publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return self();
        }

        public T notification(LocalDate notification) {
            this.notification = notification;
            return self();
        }

        public T fmi(String fmi) {
            this.fmi = fmi;
            return self();
        }

        public T notary(String notary) {
            this.notary = notary;
            return self();
        }

        public DTOResolution build() {
            return new DTOResolution(this);
        }

    }

}
