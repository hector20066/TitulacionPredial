package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;

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
    private String cadastralReference;
    private String address;
    private Municipalities municipalities;

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
        this.cadastralReference = builder.cadastralReference;
        this.address = builder.address;
        this.municipalities = builder.municipalities;
    }

    /**     * get code.     * @return the get code     */
    public int getCode() {
        return code;
    }

    /**     * set code.     * @param code the code     */
    public void setCode(int code) {
        this.code = code;
    }

    /**     * get cadastral reference.     * @return the get cadastral reference     */
    public String getCadastralReference() {
        return cadastralReference;
    }

    /**     * set cadastral reference.     * @param cadastralReference the cadastral reference     */
    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * set address.     * @param address the address     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**     * get municipalities.     * @return the get municipalities     */
    public Municipalities getMunicipalities() {
        return municipalities;
    }

    /**     * set municipalities.     * @param municipalities the municipalities     */
    public void setMunicipalities(Municipalities municipalities) {
        this.municipalities = municipalities;
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
        private String cadastralReference;
        private String address;
        private Municipalities municipalities;

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

    /**     * cadastral reference.     * @param cadastralReference the cadastral reference     * @return the cadastral reference     */
        public Builder cadastralReference(String cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

    /**     * municipalities.     * @param municipalities the municipalities     * @return the municipalities     */
        public Builder municipalities(Municipalities municipalities) {
            this.municipalities = municipalities;
            return this;
        }

        @Override
        public DTOBeneficiarySimpleDetails build() {
            return new DTOBeneficiarySimpleDetails(this);
        }

    }

}
