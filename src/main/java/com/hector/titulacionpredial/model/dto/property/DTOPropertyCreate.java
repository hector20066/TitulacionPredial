package com.hector.titulacionpredial.model.dto.property;

/**
 *
 * @author hectoracevedo
 */
public class DTOPropertyCreate {

    private long cadastralId;
    private Double area;

    public DTOPropertyCreate() {

    }

    public DTOPropertyCreate(long cadastralId, Double area) {
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
