package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) that extends {@link DTOSpouse} to include
 * beneficiary reference information for controller operations.
 *
 * <p>
 * This DTO is used to transport spouse data along with the associated
 * beneficiary identifier, facilitating the management of spouse
 * information in the presentation layer.
 * </p>
 *
 * <p>
 * It supports fluent construction using the
 * {@link DTOSpouseController.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOSpouseController extends DTOSpouse {

    private int idBeneficiary;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOSpouseController() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOSpouseController(Builder builder) {
        super(builder);
        this.idBeneficiary = builder.idBeneficiary;
    }

    /**
     * Get the beneficiary identifier associated with this spouse.
     *
     * @return beneficiary code
     */
    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    /**
     * Set the beneficiary identifier for this spouse.
     *
     * @param idBeneficiary beneficiary code to set
     */
    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    /**
     * Builder for the fluid construction of
     * {@link DTOSpouseController} instances.
     *
     * <p>
     * It allows you to configure the attributes
     * before invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOSpouse.AbstractBuilder<Builder> {

        private int idBeneficiary;

        /**
         * Set the beneficiary identifier for the spouse being built.
         *
         * @param idBeneficiary beneficiary code
         * @return instance of the builder for fluid chaining
         */
        public Builder idBeneficiary(int idBeneficiary) {
            this.idBeneficiary = idBeneficiary;
            return this;
        }

        /**
         * Build a new instance of {@link DTOSpouseController}.
         *
         * @return new DTO configured with the builder's values
         */
        public DTOSpouseController build() {
            return new DTOSpouseController(this);
        }

    }

}
