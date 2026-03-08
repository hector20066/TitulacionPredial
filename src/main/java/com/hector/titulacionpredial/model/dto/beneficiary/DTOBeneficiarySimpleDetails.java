package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 * Data Transfer Object (DTO) that contains a summary of the
 * beneficiary's information.
 *
 * <p>
 * It is used to transport data from the persistence layer to
 * the presentation layer to display the information, avoiding
 * directly exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extend {@link DTOBeneficiary} by adding information related
 * to the beneficiary's code, ID number, name, and cadastral
 * reference.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent construction using the
 * {@link DTOBeneficiarySimpleDetails.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiarySimpleDetails extends DTOBeneficiary {

    private int code;
    private long id;
    private String fullName;
    private String cadastralReference;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiarySimpleDetails() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOBeneficiarySimpleDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.cadastralReference = builder.cadastralReference;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCadastralReference() {
        return cadastralReference;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
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
    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private int code;
        private long id;
        private String fullName;
        private String cadastralReference;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder cadastralReference(String cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        @Override
        public DTOBeneficiarySimpleDetails build() {
            return new DTOBeneficiarySimpleDetails(this);
        }

    }

}
