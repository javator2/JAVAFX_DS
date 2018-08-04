package com.sda.javafx.model;

public class P {

    private String name;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String telephone;

    public P(String name, String lastName, String street, String city, String postalCode, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = postalCode;
        this.postalCode = postalCode;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
