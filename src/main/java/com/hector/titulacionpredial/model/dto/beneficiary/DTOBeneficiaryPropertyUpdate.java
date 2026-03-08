package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Data Transfer Object (DTO) that contains the information to
 * update the beneficiary's data regarding a property.
 *
 * <p>
 * It is used to transport data from the presentation layer to
 * the persistence layer to update information, avoiding directly
 * exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * It contains the property code which has been assigned to the
 * beneficiary.
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
public class DTOBeneficiaryPropertyUpdate {

    private int beneficiaryCode;
    private int propertyCode;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiaryPropertyUpdate() {

    }

    /**
     * Constructor used to initialize variables.
     *
     * @param beneficiaryCode beneficiary code
     * @param propertyCode    property code
     */
    public DTOBeneficiaryPropertyUpdate(int beneficiaryCode, int propertyCode) {
        this.beneficiaryCode = beneficiaryCode;
        this.propertyCode = propertyCode;
    }

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public void setBeneficiaryCode(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

}
