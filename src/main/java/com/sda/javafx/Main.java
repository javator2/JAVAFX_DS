package com.sda.javafx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javafx.controller.NewPersonDetails;
import com.sda.javafx.controller.PersonController;
import com.sda.javafx.controller.PersonDetails;
import com.sda.javafx.model.Person;
import com.sda.javafx.model.PersonJSON;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private VBox layout;

    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private List<PersonJSON> personJSONList = new ArrayList<PersonJSON>();

    public Main() throws IOException {

        personJSONList.add(new PersonJSON("Jan", "Kowalski", "ul. Grudziądzka", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Łukasz", "Ącki", "ul. Olsztyńska", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Krzysztof", "Bęcki", "ul. Bydgoska", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Grażyna", "Waligórska", "ul. Włocławska", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Beata", "Frąckowiak", "ul. Krakowska", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Michał", "Ciąkalski", "ul. Gdańska", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Wanda", "Berezyńska", "ul. Szczecińska", "Toruń", "87-100", "666555444"));
        personJSONList.add(new PersonJSON("Patryk", "Śmiechowski", "ul. Wrocławska", "Toruń", "87-100", "666555444"));

        ObjectMapper mapper = new ObjectMapper();
        File filename = new File("person.json");
        filename.createNewFile();
        mapper.writeValue(filename, personJSONList);

        PersonJSON[] read = mapper.readValue(new File("person.json"), PersonJSON[].class);

        for (PersonJSON p : read) {
            personList.add(new Person(p.getName(), p.getLastName(), p.getStreet(), p.getCity(), p.getPostalCode(), p.getTelephone()));
        }
    }

    public Stage getStage() {
        return stage;
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Baza pracowników w JavaFX");
        loadView();
    }

    public void loadView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/RootView.fxml"));
            layout = (VBox) loader.load();

            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.show();

            PersonController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPersonEdit(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/PersonEdit.fxml"));
            VBox window = (VBox) loader.load();

            PersonDetails personDetails = loader.getController();
            personDetails.setPerson(person);

            Stage editStage = new Stage();
            editStage.setTitle("Edytuj dane pracownika");
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

            personDetails.setStage(editStage);

        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void loadNewPerson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/NewPerson.fxml"));
            VBox window = (VBox) loader.load();

            NewPersonDetails newPersonDetails = loader.getController();

            Stage editStage = new Stage();
            editStage.setTitle("Dodaj nowego pracownika");
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

            newPersonDetails.setStage(editStage);

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
