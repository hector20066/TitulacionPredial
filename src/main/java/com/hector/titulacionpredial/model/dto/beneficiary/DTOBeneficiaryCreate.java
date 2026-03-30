package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;

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
    private String cadastralRef;
    private Municipalities municipality;
    private String address;

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
        this.cadastralRef = builder.cadastralRef;
        this.municipality = builder.municipality;
        this.address = builder.address;
    }

    /**     * get property code.     * @return the get property code     */
    public int getPropertyCode() {
        return propertyCode;
    }

    /**     * set property code.     * @param propertyCode the property code     */
    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * set cadastral ref.     * @param cadastralRef the cadastral ref     */
    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

    /**     * get municipality.     * @return the get municipality     */
    public Municipalities getMunicipality() {
        return municipality;
    }

    /**     * set municipality.     * @param municipality the municipality     */
    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * set address.     * @param address the address     */
    public void setAddress(String address) {
        this.address = address;
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
        private String cadastralRef;
        private Municipalities municipality;
        private String address;

    /**     * property code.     * @param propertyCode the property code     * @return the property code     */
        public T propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return (T) this;
        }

    /**     * cadastral ref.     * @param cadastralRef the cadastral ref     * @return the cadastral ref     */
        public T cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return (T) this;
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public T municipality(Municipalities municipality) {
            this.municipality = municipality;
            return (T) this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public T address(String address) {
            this.address = address;
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
