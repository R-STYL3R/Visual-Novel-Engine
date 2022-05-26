package ru.rstyler.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
    @FXML
    public Button exitButton;
    @FXML
    public Button startButton;
    @FXML
    public Button LoadButton;
    @FXML
    public Button settingsButton;
    @FXML
    protected ImageView Bg;



    @FXML
    Scene SettingsInit() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("SettingsMenu.fxml"));
        Scene settings = new Scene(fxmlLoader.load(), 1280, 720);
        return settings;
    }
    @FXML
    protected void StartGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("GameMenu.fxml"));
        Scene gm = new Scene(fxmlLoader.load(), 1280, 720);
        MainMenu.PrimaryStage.setScene(gm);
    }
    @FXML
    protected void LoadGame(ActionEvent event){
        LoadButton.setText("soon..");
    }

    @FXML
    protected void Settings() throws IOException {
        MainMenu.PrimaryStage.setScene(SettingsInit());

        MainMenu.PrimaryStage.show();
    }

    @FXML
    protected void onExitButton(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    Bg.setImage(new Image(String.valueOf(MainMenu.class.getResource("images/MM_BG.png"))));


    }
}