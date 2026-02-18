package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOProperty {

    private long cadastralId;
    private Double area;

    public DTOProperty() {

    }

    public DTOProperty(long cadastralId, Double area) {
        this.cadastralId = cadastralId;
        this.area = area;
    }

    public void setCadastralId(long cadastralId) {
        this.cadastralId = cadastralId;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public long getCadastralId() {
        return cadastralId;
    }

    public Double getArea() {
        return area;
    }
    
}
