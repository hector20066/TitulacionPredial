package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionDetails {

    private long resolutionNumber;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private String notary;

    public DTOResolutionDetails() {

    }

    public DTOResolutionDetails(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary) {
        this.resolutionNumber = resolutionNumber;
        this.notification = notification;
        this.executory = executory;
        this.fmi = fmi;
        this.act = act;
        this.publicWriting = publicWriting;
        this.notary = notary;
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
    
}
