package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) that represents the information of a
 * Property for entry or exit operations of the system.
 *
 * <p>
 * It is used to transport data between the presentation layer and
 * the persistence layer, avoiding direct exposure of the
 * {@code Property} entity.
 * </p>
 *
 * <p>
 * It contains the basic information of a property, such as the
 * cadastral certificate and the area of the property.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOProperty {

    /**
     * Cadastral reference.
     */
    protected String cadastralId;

    /**
     * Area of the property.
     */
    protected Double area;

    /**
     * Empty constructor required for serialization or mapping frameworks.
     */
    public DTOProperty() {

    }

    /**
     * Constructor used to initialize variables.
     *
     * @param cadastralId cadastral certificate of the property
     * @param area        area of the property
     */
    public DTOProperty(String cadastralId, Double area) {
        this.cadastralId = cadastralId;
        this.area = area;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
