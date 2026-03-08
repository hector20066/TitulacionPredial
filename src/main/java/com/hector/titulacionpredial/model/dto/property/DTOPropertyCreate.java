package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Data Transfer Object (DTO) that contains the information to
 * register properties in the system.
 *
 * <p>
 * It is used to transport data from the presentation layer to
 * the persistence layer to save the information, avoiding directly
 * exposing the {@code Property} entity.
 * </p>
 *
 * <p>
 * Extend {@link DTOProperty} by obtaining the necessary information
 * needed to register a property.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOPropertyCreate extends DTOProperty {

    /**
     * Empty constructor required for serialization or mapping
     * frameworks.
     */
    public DTOPropertyCreate() {
        super();
    }

    /**
     * Constructor used to initialize variables.
     *
     * @param cadastralId cadastral certificate of the property
     * @param area        area of the property
     */
    public DTOPropertyCreate(String cadastralId, Double area) {
        super(cadastralId, area);
    }

}
