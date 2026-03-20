package com.hector.titulacionpredial.model.dto.property;

/**
 * @author Ing. Hector Acevedo
 */
public class DTOPropertyUpdate {

    private Double area;
    private String cadastralRef;

    public DTOPropertyUpdate() {

    }

    public DTOPropertyUpdate(Double area, String cadastralRef) {
        this.area = area;
        this.cadastralRef = cadastralRef;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getCadastralRef() {
        return cadastralRef;
    }

    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

}
