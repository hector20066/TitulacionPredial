package com.hector.titulacionpredial.model.dto;

import org.apache.commons.math3.analysis.function.Abs;

/**
 * Data Transfer Object (DTO) that represents a spouse's information
 * for system input or output operations.
 *
 * <p>
 * It is used to transport data between the presentation layer and the
 * persistence layer, avoiding directly exposing the {@code Spouse}
 * entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOBasePerson} by adding specific information related
 * to the place of issue, full name, and code of {@code Beneficiary}.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluid construction using the {@link Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOSpouse extends DTOBasePerson {

    private int beneficiaryCode;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOSpouse() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOSpouse(AbstractBuilder<?> builder) {
        super(builder);
        this.beneficiaryCode = builder.beneficiaryCode;
    }

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public void setBeneficiaryCode(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    /**
     * Builder for seamless construction of {@link DTOSpouse} instances
     *
     * <p>
     * It allows you to configure the attributes before
     * invoking {@link #build()}.
     * </p>
     */
    public static class AbstractBuilder<T extends AbstractBuilder<T>> extends DTOBasePerson.Builder<T> {

        protected int beneficiaryCode;

        public T beneficiaryCode(int beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return (T) this;
        }

    }

    public static class Builder extends AbstractBuilder<Builder> {

        public DTOSpouse build() {
            return new DTOSpouse(this);
        }

    }

}
