package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;
import com.hector.titulacionpredial.model.entities.Property;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionCreate {

    private long resolutionNumber;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private Property property;

    public DTOResolutionCreate() {

    }

    public DTOResolutionCreate(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, Property property) {
        this.resolutionNumber = resolutionNumber;
        this.notification = notification;
        this.executory = executory;
        this.fmi = fmi;
        this.act = act;
        this.publicWriting = publicWriting;
        this.property = property;
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

}
