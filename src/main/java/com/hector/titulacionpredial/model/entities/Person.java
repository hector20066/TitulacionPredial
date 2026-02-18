package com.hector.titulacionpredial.model.entities;

/**
 *
 * @author hectoracevedo
 */
public class Person {

    private long id;
    private String name;
    private String lastName;
    private String address;
    private String expeditionLocation;
    private long phone;

    public Person() {

    }

    public Person(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.expeditionLocation = builder.expeditionLocation;
        this.phone = builder.phone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return  "Id= " + id +
                "\nName= " + name +
                "\nLast Name= " + lastName +
                "\nAddress= " + address +
                "\nExpedition Location= " + expeditionLocation +
                "\nPhone=" + phone;
    }

    public static class Builder<T extends Builder<T>> {

        private long id;
        private String name;
        private String lastName;
        private String address;
        private String expeditionLocation;
        private long phone;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T id(long id) {
            this.id = id;
            return self();
        }

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T lastName(String lastName) {
            this.lastName = lastName;
            return self();
        }

        public T address(String address) {
            this.address = address;
            return self();
        }

        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

        public T phone(long phone) {
            this.phone = phone;
            return self();
        }

        public Person build() {
            return new Person(this);
        }

    }

}
