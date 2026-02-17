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

    public Person(long id, String name, String lastName, String address, String expeditionLocation, long phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.expeditionLocation = expeditionLocation;
        this.phone = phone;
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

}
