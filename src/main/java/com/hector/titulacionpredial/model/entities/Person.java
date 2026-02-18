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

    public Person(Builder builder) {
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

    public static class Builder {

        private long id;
        private String name;
        private String lastName;
        private String address;
        private String expeditionLocation;
        private long phone;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        public Builder phone(long phone) {
            this.phone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}
