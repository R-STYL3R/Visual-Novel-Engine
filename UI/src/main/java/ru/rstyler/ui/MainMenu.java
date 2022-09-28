package ru.rstyler.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.tools.Utils;
import ru.rstyler.fields.Sounds;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import java.util.Objects;


public class MainMenu extends Application {
    static Stage PrimaryStage = null;
   static FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
    static File file = new File("./UI/src/main/resources/ru/rstyler/ui/images/MMmus.wav");

    static AudioInputStream audioStream;
    static {
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Clip clip;
    static {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    static FloatControl gain;
    public MainMenu() throws UnsupportedAudioFileException, IOException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        PrimaryStage = stage;
        PrimaryStage.setTitle("Void Entry");
        PrimaryStage.setScene(scene);
        PrimaryStage.setResizable(false);
        Image icon = new Image(String.valueOf(MainMenu.class.getResource("images/icon.png")));
        PrimaryStage.getIcons().add(icon);
        scene.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(MainMenu.class.getResource("MainMenu.CSS")).toExternalForm()));
        PrimaryStage.show();
        Music();
    }
    public static void Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File sets = new File ("./UI/src/main/java/ru/rstyler/ui/Settings.txt");
        Scanner set = new Scanner(sets);
        float volume = ((float) Integer.valueOf(set.next()));


        clip.open(audioStream);
        System.out.print(clip.getLevel());
        gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gain.setValue(volume);
        clip.start();
        clip.loop(10);



    }
}
