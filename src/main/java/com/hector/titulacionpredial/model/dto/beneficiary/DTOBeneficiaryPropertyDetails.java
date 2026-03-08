package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;

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

    private String fullName;
    private long id;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiaryPropertyDetails() {
        super();
    }

    /**
     * Constructor used to initialize the class parameters.
     *
     * @param fullName     full name of the beneficiary
     * @param code         unique beneficiary code
     * @param municipality municipality of residence of the beneficiary
     * @param address      beneficiary's address
     */
    public DTOBeneficiaryPropertyDetails(String fullName, long code, Municipalities municipality, String address) {
        super();
        this.fullName = fullName;
        this.id = code;
        setMunicipality(municipality);
        setAddress(address);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
