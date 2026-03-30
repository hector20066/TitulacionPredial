package com.hector.titulacionpredial.model.dto.property;

/**
 * @author Ing. Hector Acevedo
 */
public class DTOPropertyUpdate {

    private Double area;
    private String cadastralRef;

    /**
     * Create a new empty property update DTO.
     */
    public DTOPropertyUpdate() {

    }

    /**
     * Create a property update DTO with area and cadastral reference.
     *
     * @param area         the property area
     * @param cadastralRef the cadastral reference
     */
    public DTOPropertyUpdate(Double area, String cadastralRef) {
        this.area = area;
        this.cadastralRef = cadastralRef;
    }

    /**
     * Get the property area.
     *
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * Set the property area.
     *
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * Get the cadastral reference.
     *
     * @return the cadastral reference
     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * set cadastral ref.     * @param cadastralRef the cadastral ref     */
    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

}
