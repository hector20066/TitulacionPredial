package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionDetails {

    private long resolutionNumber;
    private LocalDate notification;
    private String fmi;
    private String notary;

    public DTOResolutionDetails() {

    }

    public DTOResolutionDetails(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary) {
        super();
        this.resolutionNumber = resolutionNumber;
        this.notification = notification;
        this.fmi = fmi;
        this.notary = notary;
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

}
