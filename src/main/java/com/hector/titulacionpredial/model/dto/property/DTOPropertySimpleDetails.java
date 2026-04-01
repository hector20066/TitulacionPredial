package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Data Transfer Object (DTO) that contains simplified property details.
 *
 * <p>
 * Used to transport basic property information from the persistence layer
 * to the presentation layer without directly exposing the {@code Property}
 * entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOPropertySimpleDetails extends DTOProperty {

    /**
     * Empty constructor required for serialization or mapping frameworks.
     */
    public DTOPropertySimpleDetails() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOPropertySimpleDetails(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOProperty.Builder<Builder> {

        public DTOPropertySimpleDetails build() {
            return new DTOPropertySimpleDetails(this);
        }

    }
}
