package com.sda.javafx.controller;

import com.sda.javafx.Main;
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

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void initialize() {
        name.setText("To jest test");
    }

    public void setStage(Stage stage) {
        this.stage = stage;

    }

    public void setPerson(Person person) {
        this.person = person;
        if (person != null) {
            name.setText(person.getName());
            lastName.setText(person.getLastName());
            street.setText(person.getStreet());
            city.setText(person.getCity());
            postalCode.setText(person.getPostalCode());
            telephoneNumber.setText(person.getTelephone());
        }
    }

    public void handleClosePerson() {
        this.stage.close();
    }

    public void handlePersonEditSave() {
        person.setName(name.getText());
        person.setLastName(lastName.getText());
        person.setStreet(street.getText());
        person.setCity(city.getText());
        person.setPostalCode(postalCode.getText());
        person.setTelephone(telephoneNumber.getText());
        this.stage.close();
    }

    @FXML
    private void handleNewPersonSave() {
//        Person tempPerson = new Person();
//        main.loadPersonEdit(tempPerson);
//        main.getPersonList().add(tempPerson);
        person.setName(name.getText());
        person.setLastName(lastName.getText());
        person.setStreet(street.getText());
        person.setCity(city.getText());
        person.setPostalCode(postalCode.getText());
        person.setTelephone(telephoneNumber.getText());
        main.getPersonList().add(person);
        this.stage.close();
    }
}
