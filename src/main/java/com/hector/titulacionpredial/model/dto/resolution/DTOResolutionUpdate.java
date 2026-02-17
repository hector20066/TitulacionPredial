package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionUpdate {

    private LocalDate executory;
    private String act;
    private String publicWriting;

    public DTOResolutionUpdate() {

    }

    public DTOResolutionUpdate(LocalDate executory, String act, String publicWriting) {
        this.executory = executory;
        this.act = act;
        this.publicWriting = publicWriting;
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
    
}
