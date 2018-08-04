package com.sda.javafx.controller;

import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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

    private Person person;

    private Stage stage;

    @FXML
    public void initialize() {
        name.setText("To jest test");
    }

    public void setStage(Stage stage) {
        this.stage = stage;

    }

    public void setPerson(Person person) {
        this.person = person;
        name.setText(person.getName());
        lastName.setText(person.getLastName());
        street.setText(person.getStreet());
        city.setText(person.getCity());
        postalCode.setText(person.getPostalCode());
        telephoneNumber.setText(person.getTelephone());
    }

    public void handleSavePersonEdit() {
        person.setName(name.getText());
        person.setLastName(lastName.getText());
        person.setStreet(street.getText());
        person.setCity(city.getText());
        person.setPostalCode(postalCode.getText());
        person.setTelephone(telephoneNumber.getText());
        this.stage.close();
    }

    public void handleClosePersonEdit() {
        this.stage.close();
    }
}
