package com.sda.javafx;

import com.sda.javafx.controller.PersonController;
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

    public Main(){
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Łukasz", "Ącki"));
        personList.add(new Person("Krzysztof", "Bęcki"));
        personList.add(new Person("Grażyna", "Waligórska"));
        personList.add(new Person("Beata", "Frąckowiak"));
        personList.add(new Person("Michał", "Ciąkalski"));
        personList.add(new Person("Wanda", "Berezyńska"));
        personList.add(new Person("Patryk", "Śmiechowski"));
    }

    public ObservableList<Person> getPersonList(){
        return personList;
    }

    public static void main(String[] args) {
        launch();

    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Moa aplikacja w JavaFX");
        loadView();
    }

    public void loadView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/rootview.fxml"));
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

    public void loadPersonEdit() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/personedit.fxml"));
            VBox window = (VBox) loader.load();

            Stage editStage = new Stage();
            editStage.setTitle("edytuj osobę");
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException err){
            err.printStackTrace();
        }
    }
}
