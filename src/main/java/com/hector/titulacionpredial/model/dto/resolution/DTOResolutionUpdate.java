package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) that contains the information
 * to update the data of a resolution.
 *
 * <p>
 * It is used to transport data from the presentation layer
 * to the persistence layer to update information, avoiding
 * directly exposing the {@code Resolution} entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOResolution} by adding specific information
 * related to the resolution code.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules.
 * Its sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent building using the
 * {@link DTOResolution.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOResolutionUpdate extends DTOResolution {

    private int code;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOResolutionUpdate() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOResolutionUpdate(Builder builder) {
        super(builder);
        this.code = builder.code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Builder for the smooth construction of
     * {@link DTOResolutionUpdate} instances.
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;

    /**
     * Set the resolution code.
     *
     * @param code the resolution code
     * @return current builder instance
     */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        @Override
    /**
     * Build and return a new {@link DTOResolutionUpdate} instance.
     *
     * @return configured DTOResolutionUpdate instance
     */
        public DTOResolutionUpdate build() {
            return new DTOResolutionUpdate(this);
        }

    }

}
