package ru.rstyler.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class SettingsController {
    @FXML
    static protected Slider MusicVolume = new Slider(0.0, 100.0, 20.0);
    @FXML
    protected Label MusicVol;
    @FXML
    protected Slider SoundVolume;
    @FXML
    protected Button ConfirmOptions;

    @FXML
    protected void BackToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
        Scene alfa = new Scene(fxmlLoader.load());
        alfa.getStylesheets().add(Objects.requireNonNull(getClass().getResource("MainMenu.css")).toExternalForm());
        MainMenu.PrimaryStage.setScene(alfa);

    }
    @FXML
    protected void MusicVolumeSet(){

    }
    @FXML
    protected void MusicVolumeChange() {
         MusicVol.setText(String.valueOf(MusicVolume.getValue()));


    }
}
