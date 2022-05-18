package ru.rstyler.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class SettingsController {
    @FXML
    protected Slider MusicVolume = new Slider(0.0, 100.0, 20.0);
    @FXML
    protected Text MusicVol;
    @FXML
    protected Slider SoundVolume;

    @FXML
    protected void BackToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
        Scene alfa = new Scene(fxmlLoader.load());
        alfa.getStylesheets().add(Objects.requireNonNull(getClass().getResource("MainMenu.css")).toExternalForm());
        MainMenu.PrimaryStage.setScene(alfa);

    }
    @FXML
    protected void MusicVolumeSet(){
        MusicVolume.setMin(0);
        MusicVolume.setMax(100);
    }
    @FXML
    protected void MusicVolumeChange(ActionEvent event) {
        MusicVolume.setMin(0.0);
        MusicVolume.setMax(100.0);
        // MusicVol.setText(String.valueOf(MusicVolume.getValue()));
    }
}
