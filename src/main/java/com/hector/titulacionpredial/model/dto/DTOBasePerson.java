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
    public DTOBasePerson(Builder<?> builder) {
        this.fullName = builder.fullName;
        this.id = builder.id;
        this.phone = builder.phone;
        this.expeditionLocation = builder.expeditionLocation;
    }

    /**     * get full name.     * @return the get full name     */
    public String getFullName() {
        return fullName;
    }

    /**     * set full name.     * @param fullName the full name     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**     * get id.     * @return the get id     */
    public long getId() {
        return id;
    }

    /**     * set id.     * @param id the id     */
    public void setId(long id) {
        this.id = id;
    }

    /**     * get phone.     * @return the get phone     */
    public long getPhone() {
        return phone;
    }

    /**     * set phone.     * @param phone the phone     */
    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**     * get expedition location.     * @return the get expedition location     */
    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    /**     * set expedition location.     * @param expeditionLocation the expedition location     */
    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public static class Builder<T extends Builder<T>> {

        private String fullName;
        private long id;
        private long phone;
        private String expeditionLocation;

        /**
         * Returns the concrete instance of the builder.
         *
         * @return typed instance of the builder
         */
        @SuppressWarnings("unchecked")
    /**     * self.     * @return the self     */
        protected T self() {
            return (T) this;
        }

    /**     * full name.     * @param fullName the full name     * @return the full name     */
        public T fullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

    /**     * id.     * @param id the id     * @return the id     */
        public T id(long id) {
            this.id = id;
            return self();
        }

    /**     * phone.     * @param phone the phone     * @return the phone     */
        public T phone(long phone) {
            this.phone = phone;
            return self();

        }

    /**     * expedition location.     * @param expeditionLocation the expedition location     * @return the expedition location     */
        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

    /**     * build.     * @return the build     */
        public DTOBasePerson build() {
            return new DTOBasePerson(this);
        }

    }

}
