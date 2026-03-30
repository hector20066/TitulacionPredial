package com.hector.titulacionpredial.model.entities;

/**
 * Base entity that represents a person within the domain of the
 * Land Titling system.
 *
 * <p>
 * Define the common attributes that entities representing actors
 * in the system must possess.
 * </p>
 *
 * <p>
 * This class:
 * </p>
 * <ul>
 *     <li>It has its own identity through the {@code id} attribute.</li>
 *     <li>It is mutable through setter methods.</li>
 *     <li>It supports building using the {@link Builder} pattern.</li>
 * </ul>
 *
 * <p>
 * It can be extended to specialize different types of people
 * within the domain model.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Person {

    protected long id;
    protected String fullName;
    protected String expeditionLocation;
    protected long phone;

    /**
     * Empty constructor required for persistence frameworks or
     * reflection mechanisms.
     */
    public Person() {

    }

    /**
     * Protected constructor used by the Builder pattern.
     *
     * @param builder step-by-step constructor instance
     */
    protected Person(Builder<?> builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.expeditionLocation = builder.expeditionLocation;
        this.phone = builder.phone;
    }

    /**     * get id.     * @return the get id     */
    public long getId() {
        return id;
    }

    /**     * set id.     * @param id the id     */
    public void setId(long id) {
        this.id = id;
    }

    /**     * get full name.     * @return the get full name     */
    public String getFullName() {
        return fullName;
    }

    /**     * set full name.     * @param fullName the full name     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**     * get expedition location.     * @return the get expedition location     */
    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    /**     * set expedition location.     * @param expeditionLocation the expedition location     */
    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    /**     * get phone.     * @return the get phone     */
    public long getPhone() {
        return phone;
    }

    /**     * set phone.     * @param phone the phone     */
    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * Textual representation of the entity.
     *
     * @return formatted description of the main attributes
     */
    @Override
    /**     * to string.     * @return the to string     */
    public String toString() {
        return "Id= " + id +
                "\nName= " + fullName +
                "\nExpedition Location= " + expeditionLocation +
                "\nPhone=" + phone;
    }

    /**
     * Generic implementation of the Builder pattern to allow
     * the smooth and secure construction of {@link Person}
     * instances and their subclasses.
     *
     * <p>
     * Use the "self type generics" pattern to support inheritance
     * without losing the concrete type in subclasses.
     * </p>
     *
     * @param <T> specific type of extended builder
     */
    public static class Builder<T extends Builder<T>> {

        private long id;
        private String fullName;
        private String expeditionLocation;
        private long phone;

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

        /**
         * Set the identifier.
         *
         * @param id unique identifier
         * @return current builder
         */
        public T id(long id) {
            this.id = id;
            return self();
        }

        /**
         * Enter the full name.
         *
         * @param fullName full name
         * @return current builder
         */
        public T fullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

        /**
         * Establish the place of shipment.
         *
         * @param expeditionLocation city or place of shipment
         * @return current builder
         */
        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

        /**
         * Enter the phone number.
         *
         * @param phone contact number
         * @return current builder
         */
        public T phone(long phone) {
            this.phone = phone;
            return self();
        }

        /**
         * Create a new instance of {@link Person}.
         *
         * @return new person constructed
         */
        public Person build() {
            return new Person(this);
        }

    }

}
