package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonController {

    private Main main;

    @FXML
    private TableView<Person> personTable;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private TableColumn<Person, String> firstNameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;
    @FXML
    private Button newButton;

    private Stage stage;

    @FXML
    public void handleNewPerson() {
        this.main.loadNewPerson();
//        Person tempPerson = new Person();
//        main.loadPersonEdit(tempPerson);
//        main.getPersonList().add(tempPerson);
    }


    @FXML
    public void handlePersonEdit() {
        Person selectPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectPerson != null) {
            this.main.loadPersonEdit(selectPerson);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Brak osoby");
            alert.setContentText("Nikt nie został wybrany");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeletePerson() {
        int index = personTable.getSelectionModel().getSelectedIndex();
        Person selectPerson = personTable.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Czy na pewno usunąć " + selectPerson.getName() + " " + selectPerson.getLastName() + "?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            if (index >= 0) {
                personTable.getItems().remove(index);
            }
        }
    }

    @FXML
    public void handleSavePerson() throws IOException {
        main.save();
    }

    @FXML
    public void showPersonDetails(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
            postalCodeLabel.setText(person.getPostalCode());
            telephoneLabel.setText(person.getTelephone());
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
            telephoneLabel.setText("");
        }
    }

    @FXML
    public void initialize() {
        firstNameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell -> cell.getValue().lastNameProperty());

        showPersonDetails(null);

        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldField, newField) -> showPersonDetails(newField));
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(main.getPersonList());
    }
}
