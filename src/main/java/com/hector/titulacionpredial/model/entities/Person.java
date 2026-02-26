package com.hector.titulacionpredial.model.entities;

/**
 *
 * @author hectoracevedo
 */
public class Person {

    private long id;
    private String fullName;
    private String address;
    private String expeditionLocation;
    private long phone;

    public Person() {

    }

    public Person(Builder<?> builder) {
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

    @Override
    public String toString() {
        return "Id= " + id +
                "\nName= " + fullName +
                "\nAddress= " + address +
                "\nExpedition Location= " + expeditionLocation +
                "\nPhone=" + phone;
    }

    public static class Builder<T extends Builder<T>> {

        private long id;
        private String fullName;
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

        public T fullName(String fullName) {
            this.fullName = fullName;
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
