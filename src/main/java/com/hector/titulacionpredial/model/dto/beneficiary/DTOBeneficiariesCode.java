package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Data Transfer Object (DTO) that contains beneficiary information
 * indexed by cadastral reference code.
 *
 * <p>
 * This DTO encapsulates the essential identification and location
 * information of a beneficiary, including the cadastral reference,
 * address, and beneficiary code.
 * </p>
 *
 * <p>
 * It is used to transport beneficiary lookup data from the persistence
 * layer to the presentation layer while avoiding direct exposure of
 * the {@code Beneficiary} entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiariesCode {

    private String cadastral_reference;
    private String address;
    private int code;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiariesCode() {

    }

    /**
     * Constructor to initialize the beneficiary code information.
     *
     * @param cadastral_reference cadastral reference of the property
     * @param address             address of the beneficiary
     * @param code                unique beneficiary code
     */
    public DTOBeneficiariesCode(String cadastral_reference, String address, int code) {
        this.cadastral_reference = cadastral_reference;
        this.address = address;
        this.code = code;
    }

    public String getCadastral_reference() {
        return cadastral_reference;
    }

    public void setCadastral_reference(String cadastral_reference) {
        this.cadastral_reference = cadastral_reference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
