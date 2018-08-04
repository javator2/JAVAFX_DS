package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class PersonDetails {
    @FXML
    private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField telephoneNumber;

    @FXML
    public void initialize(){
        name.setText("To jest test");

    }
    public void setPerson(Person person){
        name.setText(person.getName());
        lastName.setText(person.getLastName());
        street.setText(person.getStreet());
        city.setText(person.getCity());
        postalCode.setText(person.getPostalCode());
        telephoneNumber.setText(person.getTelephone());
    }
}
