package ru.rstyler.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    @FXML
    public Button exitButton;
    @FXML
    public Button startButton;
    @FXML
    public Button LoadButton;
    @FXML
    public Button settingsButton;
    @FXML
    Scene SettingsInit() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("SettingsMenu.fxml"));
        Scene settings = new Scene(fxmlLoader.load(), 1280, 720);
       
        return settings;
    }
    @FXML
    protected void StartGame(ActionEvent event){
    startButton.setText("gay!");
    }
    @FXML
    protected void LoadGame(ActionEvent event){
        startButton.setText("you are gay");
    }
    @FXML
    protected void Settings(ActionEvent event) throws IOException {
        MainMenu.PrimaryStage.setScene(SettingsInit());

    }
    @FXML
    protected void onExitButton(ActionEvent event) {
        System.exit(0);
    }
}