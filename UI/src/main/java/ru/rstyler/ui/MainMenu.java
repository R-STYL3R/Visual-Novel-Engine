package ru.rstyler.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class MainMenu extends Application {
    static Stage PrimaryStage = null;
   static FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene( fxmlLoader.load(), 1280, 720);
        PrimaryStage = stage;
        PrimaryStage.setTitle("Void Entry");
        PrimaryStage.setScene(scene);
        PrimaryStage.setResizable(false);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("MainMenu.css")).toExternalForm());
        PrimaryStage.show();
    }
}
