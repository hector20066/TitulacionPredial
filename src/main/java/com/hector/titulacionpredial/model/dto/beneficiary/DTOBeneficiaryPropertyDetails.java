package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) that contains the information
 * obtained from a beneficiary.
 *
 * <p>
 * It is used to transport data from the persistence layer
 * to the presentation layer to display the information,
 * avoiding directly exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extend {@link DTOBeneficiary} by adding special information
 * related to the beneficiary's full name and ID number.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules.
 * Its sole purpose is to encapsulate data.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryPropertyDetails extends DTOBeneficiary {

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiaryPropertyDetails() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOBeneficiaryPropertyDetails(Builder builder) {
        super(builder);

    }

    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        public DTOBeneficiaryPropertyDetails build() {
            return new DTOBeneficiaryPropertyDetails(this);
        }

    }

}
