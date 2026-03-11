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
     * Full name of the person.
     */
    protected String fullName;

    /**
     * ID card of the person.
     */
    protected long id;

    /**
     * Address associated with the person.
     */
    protected String address;

    /**
     * Contact phone number.
     */
    protected long phone;

    /**
     * Expedition site ID card of the person
     */
    protected String expeditionLocation;

    /**
     * Empty constructor required for serialization or automatic
     * mapping frameworks.
     */
    public DTOBasePerson() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOBasePerson(Builder builder) {
        this.fullName = builder.fullName;
        this.id = builder.id;
        this.address = builder.address;
        this.phone = builder.phone;
        this.expeditionLocation = builder.expeditionLocation;
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

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public static class Builder<T extends Builder<T>> {

        private String fullName;
        private long id;
        private String address;
        private long phone;
        private String expeditionLocation;

        /**
         * Returns the concrete instance of the builder.
         *
         * @return typed instance of the builder
         */
        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T fullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

        public T id(long id) {
            this.id = id;
            return self();
        }

        public T address(String address) {
            this.address = address;
            return self();
        }

        public T phone(long phone) {
            this.phone = phone;
            return self();

        }

        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

        public DTOBasePerson build() {
            return new DTOBasePerson(this);
        }

    }

}
