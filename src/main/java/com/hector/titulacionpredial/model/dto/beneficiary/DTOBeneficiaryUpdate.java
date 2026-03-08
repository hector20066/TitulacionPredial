package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) that contains the information
 * to update the beneficiary's data.
 *
 * <p>
 * It is used to transport data from the presentation layer
 * to the persistence layer to update information, avoiding
 * directly exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOBeneficiary} by adding specific information
 * related to the code used to identify the beneficiary.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent building using the
 * {@link DTOBeneficiaryUpdate.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryUpdate extends DTOBeneficiary {

    private int code;

    /**
     * Empty constructor required for serialization
     * or mapping frameworks.
     */
    public DTOBeneficiaryUpdate() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOBeneficiaryUpdate(Builder builder) {
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
     * Builder for the fluid construction of
     * {@link DTOBeneficiaryUpdate} instances.
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private int code;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        @Override
        public DTOBeneficiaryUpdate build() {
            return new DTOBeneficiaryUpdate(this);
        }

    }

}
