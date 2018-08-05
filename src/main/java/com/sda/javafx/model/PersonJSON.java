package com.sda.javafx.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonJSON {

    private String name;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String telephone;

    public PersonJSON(){}

    public PersonJSON(String name, String lastName, String street, String city, String postalCode, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
    }
}
