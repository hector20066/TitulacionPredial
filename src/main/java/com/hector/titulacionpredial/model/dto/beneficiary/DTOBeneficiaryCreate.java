package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) that contains the information to
 * register a beneficiary in the system.
 *
 * <p>
 * It is used to transport data from the presentation layer to
 * the persistence layer to save the information, avoiding
 * directly exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extend {@link DTOBeneficiary} by adding specific information
 * related to the place of issuance, the cadastral reference, and
 * personal data.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent building using the
 * {@link DTOBeneficiaryCreate.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryCreate extends DTOBeneficiary {

    private int propertyCode;

    /**
     * Empty constructor required for serialization
     * or mapping frameworks.
     */
    public DTOBeneficiaryCreate() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOBeneficiaryCreate(AbstractBuilder<?> builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    /**
     * Generic builder for fluid building of
     * {@link DTOBeneficiaryCreate} instances.
     *
     * <p>
     * It allows you to configure the attributes
     * before invoking {@link #build()}.
     * </p>
     *
     * @param <T> specific type of builder
     */
    public abstract static class AbstractBuilder<T extends AbstractBuilder<T>> extends DTOBeneficiary.Builder<T> {

        private int propertyCode;

        public T propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return (T) this;
        }

    }

    /**
     * Builder with concrete implementation of the
     * {@link #build()} method for creating the
     * {@link DTOBeneficiaryCreate} instance.
     */
    public static class Builder extends AbstractBuilder<Builder> {

        /**
         * Create a new instance of {@link DTOBeneficiaryCreate}
         *
         * @return new DTO configured
         */
        @Override
        public DTOBeneficiaryCreate build() {
            return new DTOBeneficiaryCreate(this);
        }

    }

}
