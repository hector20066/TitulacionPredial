package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOProperty {

    private String cadastralId;
    private Double area;

    public DTOProperty() {

    }

    public DTOProperty(String cadastralId, Double area) {
        this.cadastralId = cadastralId;
        this.area = area;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public Double getArea() {
        return area;
    }

}
