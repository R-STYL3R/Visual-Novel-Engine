package ru.rstyler.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import ru.rstyler.FileReader;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SettingsController implements Initializable {
    static int MusVolumeValue;
    @FXML
    protected Slider MusicVolumeSlider;
    @FXML
    protected Slider SoundVolumeSlider;
    static int SoundValue;
    @FXML
    protected CheckBox AutoRead;
    @FXML
    protected CheckBox SkipText;
    @FXML
    protected Button ConfirmOptions;
    protected File sets = new File ("Z:\\project_Z\\visual-novel-engine\\UI\\src\\main\\java\\ru\\rstyler\\ui\\Settings.txt");

    @FXML
    protected void BackToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
        Scene alfa = new Scene(fxmlLoader.load());
        alfa.getStylesheets().add(Objects.requireNonNull(getClass().getResource("MainMenu.css")).toExternalForm());
        MainMenu.PrimaryStage.setScene(alfa);
    }
    protected static double getMusValue(){
        return MusVolumeValue;
    }
    protected static double getSoundValue(){
        return SoundValue;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NumberFormatException {
        Scanner ConfigInspect = null;
        try {
            ConfigInspect = new Scanner(sets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int mus,soun;

        try {
             mus = Integer.valueOf(ConfigInspect.next());
             soun = Integer.valueOf(ConfigInspect.next());
            MusicVolumeSlider.setValue(mus);
            MusVolumeValue = (int) MusicVolumeSlider.getValue();


            SoundVolumeSlider.setValue(soun);
            SoundValue = (int) SoundVolumeSlider.getValue();
        } catch (NumberFormatException e) {
          System.out.print("Wrong type of int");
        }





       /* SoundValue = (int) SoundVolumeSlider.getValue();
        SoundVolumeArea.setText(Integer.toString(SoundValue));

        MusVolumeValue = (int) MusicVolumeSlider.getValue();
        MusicVolumeArea.setText(Integer.toString(MusVolumeValue));*/
        MusicVolumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                MusVolumeValue = (int) MusicVolumeSlider.getValue();

            }
        });
        SoundVolumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                SoundValue = (int) SoundVolumeSlider.getValue();

            }
        });


    }
    @FXML
    protected void SaveConfig() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        FileWriter SetSave = new FileWriter(sets);
        SetSave.write((int)MusicVolumeSlider.getValue()+"\n");
        SetSave.write((int)SoundVolumeSlider.getValue()+"\n");
        SetSave.close();

        MainMenu.gain.setValue((float)MusicVolumeSlider.getValue());
    }


}
