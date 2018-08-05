package com.sda.javafx.controller;

import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonDetails {

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

    public void setStage(Stage stage) {
        this.stage = stage;

    }

    public void handleSaveNewPerson() {
        Person person = new Person(name.getText(), lastName.getText(), street.getText(), city.getText(), postalCode.getText(), telephoneNumber.getText());
        this.stage.close();
    }

    public void handleCloseNewPerson() {
        this.stage.close();
    }
}
