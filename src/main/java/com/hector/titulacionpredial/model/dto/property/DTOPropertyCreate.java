package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;

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
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOPropertyCreate(Builder builder) {
        super(builder);
    }

    /**
     * Builder for the fluid construction of
     * {@link DTOBeneficiarySimpleDetails} instances.
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOProperty.Builder<Builder> {

        @Override
        public DTOPropertyCreate build() {
            return new DTOPropertyCreate(this);
        }

    }

}
