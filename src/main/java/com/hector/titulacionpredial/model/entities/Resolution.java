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
    private Property property;

    public Resolution() {

    }

    public Resolution(int code, long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, Property property) {
        this.code = code;
        this.resolutionNumber = resolutionNumber;
        this.notification = notification;
        this.executory = executory;
        this.fmi = fmi;
        this.act = act;
        this.publicWriting = publicWriting;
        this.property = property;
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

    public void setProperty(Property property) {
        this.property = property;
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

    public Property getProperty() {
        return property;
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
                "\nProperty= " + property;
    }

}
