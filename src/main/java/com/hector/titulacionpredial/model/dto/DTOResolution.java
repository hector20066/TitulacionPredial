package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolution {

    private LocalDate executory;
    private String act;
    private String publicWriting;

    public DTOResolution() {

    }

    public DTOResolution(Builder builder) {
        this.executory = builder.executory;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
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

    public LocalDate getExecutory() {
        return executory;
    }

    public String getAct() {
        return act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public static class Builder {

        private LocalDate executory;
        private String act;
        private String publicWriting;

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

        public DTOResolution build() {
            return new DTOResolution(this);
        }

    }

}
