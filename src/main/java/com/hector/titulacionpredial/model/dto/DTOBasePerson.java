package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) base that contains common information
 * related to personal data.
 *
 * <p>
 * This class is used to transport information between layers of the
 * system (for example, between the presentation layer and the
 * application layer) without directly exposing the domain entities.
 * </p>
 *
 * <p>
 * It contains no business logic and its sole responsibility is to
 * encapsulate data.
 * </p>
 *
 * <p>
 * It is mutable and designed to be used as a simple transport object.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBasePerson {

    /**
     * Address associated with the person.
     */
    protected String address;

    /**
     * Contact phone number.
     */
    protected long phone;

    /**
     * Empty constructor required for serialization or automatic
     * mapping frameworks.
     */
    public DTOBasePerson() {

    }

    /**
     * Constructor to initialize parameters.
     *
     * @param address person's address
     * @param phone   telephone number
     */
    public DTOBasePerson(String address, long phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

}
