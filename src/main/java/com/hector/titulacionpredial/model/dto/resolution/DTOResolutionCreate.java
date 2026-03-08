package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) that contains the information obtained
 * from a resolution.
 *
 * <p>
 * It is used to transport data from the presentation layer to the
 * persistence layer to save the information, avoiding directly
 * exposing the {@code Resolution} entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOResolution} by adding specific information
 * related to the property code and beneficiary name.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent building using the
 * {@link DTOResolutionCreate.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOResolutionCreate extends DTOResolution {

    private int propertyCode;
    private String beneficiaryName;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOResolutionCreate() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOResolutionCreate(Builder builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
        this.beneficiaryName = builder.beneficiaryName;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Builder for the smooth construction of
     * {@link DTOResolutionCreate} instances.
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int propertyCode;
        private String beneficiaryName;

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        @Override
        public DTOResolutionCreate build() {
            return new DTOResolutionCreate(this);
        }

    }

}
