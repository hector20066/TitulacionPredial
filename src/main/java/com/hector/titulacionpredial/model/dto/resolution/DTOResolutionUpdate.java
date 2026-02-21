package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionUpdate extends DTOResolution {

    private int code;
    private LocalDate notification;
    private String fmi;
    private String notary;

    public DTOResolutionUpdate() {
        super();
    }

    public DTOResolutionUpdate(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getCode() {
        return code;
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

        private int code;
        private LocalDate notification;
        private String fmi;
        private String notary;

        public Builder code(int code) {
            this.code = code;
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

        @Override
        public DTOResolutionUpdate build() {
            return new DTOResolutionUpdate(this);
        }

    }

}
