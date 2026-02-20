package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOProperty {

    private int propertyCode;
    private String cadastralId;
    private Double area;

    public DTOProperty() {

    }

    public DTOProperty(int propertyCode, String cadastralId, Double area) {
        this.propertyCode = propertyCode;
        this.cadastralId = cadastralId;
        this.area = area;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public Double getArea() {
        return area;
    }

}
