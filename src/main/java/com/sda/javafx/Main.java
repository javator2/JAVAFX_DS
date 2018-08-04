package com.sda.javafx;

import com.sda.javafx.controller.NewPersonDetails;
import com.sda.javafx.controller.PersonController;
import com.sda.javafx.controller.PersonDetails;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private VBox layout;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main() {

//    }
//
//    public static void main(String[] args) throws IOException {
//        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person("Jan", "Kowalski", "ul. Grudziądzka", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Łukasz", "Ącki", "ul. Olsztyńska", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Krzysztof", "Bęcki", "ul. Bydgoska", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Grażyna", "Waligórska", "ul. Włocławska", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Beata", "Frąckowiak", "ul. Krakowska", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Michał", "Ciąkalski", "ul. Gdańska", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Wanda", "Berezyńska", "ul. Szczecińska", "Toruń", "87-100", "666555444"));
        personList.add(new Person("Patryk", "Śmiechowski", "ul. Wrocławska", "Toruń", "87-100", "666555444"));


//        ObjectMapper mapper = new ObjectMapper();
//        File filename = new File("person.json");
//        filename.createNewFile();
//        mapper.writeValue(filename, personList);
//
//        Person[] read = mapper.readValue(new File("person.json"), Person[].class);
//
//        ObservableList<Person> personListFX = FXCollections.observableArrayList();
//
//        for(Person p:  read){
//            System.out.println(p.getName());
//            personListFX.add(new Person(p.getName(), p.getLastName(), p.getStreet(), p.getCity(), p.getPostalCode(), p.getTelephone()));
//        }

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public Stage getStage() {
        return stage;
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

//            NewPersonDetails newPersonDetails = loader.getController();
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
    public static void main(String[] args) {
        launch(args);
    }
}
