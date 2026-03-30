package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 * Data Transfer Object (DTO) that contains the information
 * obtained from a resolution.
 *
 * <p>
 * It is used to transport data from the persistence layer
 * to the presentation layer to display information, avoiding
 * directly exposing the {@code Resolution} entity.
 * </p>
 *
 * <p>
 * Extend {@link DTOResolution} by adding specific information
 * related to the code and beneficiary name.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent construction using the
 * {@link DTOResolutionDetails.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOResolutionDetails extends DTOResolution {

    private int code;
    private String beneficiaryName;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOResolutionDetails() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOResolutionDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.beneficiaryName = builder.beneficiaryName;
    }

    /**     * get code.     * @return the get code     */
    public int getCode() {
        return code;
    }

    /**     * set code.     * @param code the code     */
    public void setCode(int code) {
        this.code = code;
    }

    /**     * get beneficiary name.     * @return the get beneficiary name     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**     * set beneficiary name.     * @param beneficiaryName the beneficiary name     */
    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    /**
     * Builder for the seamless construction of
     * {@link DTOResolutionDetails} instances.
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;
        private String beneficiaryName;

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

    /**     * beneficiary name.     * @param beneficiaryName the beneficiary name     * @return the beneficiary name     */
        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        @Override
    /**     * build.     * @return the build     */
        public DTOResolutionDetails build() {
            return new DTOResolutionDetails(this);
        }

    }

}
