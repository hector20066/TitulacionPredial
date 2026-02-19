package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolution {

    private long resolutionNumber;
    private LocalDate executory;
    private String act;
    private String publicWriting;

    public DTOResolution() {

    }

    public DTOResolution(Builder<?> builder) {
        this.resolutionNumber = builder.resolutionNumber;
        this.executory = builder.executory;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public long getResolutionNumber() {
        return resolutionNumber;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public String getAct() {
        return act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public static class Builder<T extends Builder<T>> {

        private long resolutionNumber;
        private LocalDate executory;
        private String act;
        private String publicWriting;

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

        public DTOResolution build() {
            return new DTOResolution(this);
        }

    }

}
