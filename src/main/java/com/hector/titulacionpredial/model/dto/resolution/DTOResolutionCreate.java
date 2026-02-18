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
    private String fmi;
    private String notary;
    private int propertyCode;

    public DTOResolutionCreate() {

    }

    public DTOResolutionCreate(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act, String publicWriting, String notary, int propertyCode) {
        super();
        this.resolutionNumber = resolutionNumber;
        this.notification = notification;
        this.fmi = fmi;
        this.notary = notary;
        this.propertyCode = propertyCode;
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

    public void setPropertyCode(int property) {
        this.propertyCode = propertyCode;
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

    public int getPropertyCode() {
        return propertyCode;
    }

}
