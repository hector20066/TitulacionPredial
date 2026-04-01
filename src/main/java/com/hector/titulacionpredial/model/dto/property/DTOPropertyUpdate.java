package com.hector.titulacionpredial.model.dto.property;

/**
 * Data Transfer Object (DTO) that contains the information to update
 * a property in the system.
 *
 * <p>
 * Used to transport property update data from the presentation layer to
 * the persistence layer, avoiding direct exposure of the {@code Property}
 * entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
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
