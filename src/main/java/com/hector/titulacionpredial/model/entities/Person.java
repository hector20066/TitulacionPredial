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
    protected String address;
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
        this.address = builder.address;
        this.expeditionLocation = builder.expeditionLocation;
        this.phone = builder.phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * Textual representation of the entity.
     *
     * @return formatted description of the main attributes
     */
    @Override
    public String toString() {
        return "Id= " + id +
                "\nName= " + fullName +
                "\nAddress= " + address +
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
        private String address;
        private String expeditionLocation;
        private long phone;

        /**
         * Returns the concrete instance of the builder.
         *
         * @return typed instance of the builder
         */
        @SuppressWarnings("unchecked")
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
         * Set the direction.
         *
         * @param address residential address
         * @return current builder
         */
        public T address(String address) {
            this.address = address;
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
