package ru.rstyler.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.rstyler.fields.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;


public class GMController implements Initializable {
    static Character Tor = new Character();
   @FXML
   protected Label CharName;
   @FXML
   protected Label CharPhrase;
   @FXML
   protected ImageView BGPlace;
   @FXML
   protected ImageView SpritePlace;
   @FXML
    protected Label MM;
    @FXML
    protected Label Set;
    @FXML
    protected Label Save;

    int pervert=1;
    Scanner alfa = new Scanner(new File("Z:\\project_Z\\visual-novel-engine\\UI\\src\\main\\resources\\ru\\rstyler\\ui\\config.txt"));
    public GMController() throws FileNotFoundException {
    }

    @FXML
   protected void ScenarioGoes(MouseEvent event) throws IOException {
        if(alfa.hasNext() && pervert<=3){
            CharPhrase.setText(alfa.nextLine());
            pervert++;
        }else if (alfa.hasNext() && pervert==4){
            CharPhrase.setText(alfa.nextLine());
            BGPlace.setImage(new Image(String.valueOf(GMController.class.getResource("images/Town.png"))));
            pervert++;
        }else if(alfa.hasNext() && pervert == 5) {
            CharPhrase.setText(alfa.nextLine());
            SpritePlace.setImage(new Image(String.valueOf(GMController.class.getResource("images/Tor2.png"))));
            pervert++;
        }else if(pervert>5 && alfa.hasNextLine()){
            CharPhrase.setText(alfa.nextLine());
            pervert++;
        }else{
            BackToMenu();
        }
   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BGPlace.setImage(new Image(String.valueOf(GMController.class.getResource("images/Park.png"))));
        SpritePlace.setImage(new Image(String.valueOf(GMController.class.getResource("images/Tor.png"))));
        Tor.setName("Торнике");
        CharName.setText(Tor.getName());
        CharPhrase.setText(Tor.Phrase("Меня зовут Торнике Напирели, я родился на Сицилии в 25 году. Это — наша семья. Стою с родителями и сестрой Франческой..."));
    }
    @FXML
    protected void BackToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
        Scene alfa = new Scene(fxmlLoader.load());
        alfa.getStylesheets().add(Objects.requireNonNull(getClass().getResource("MainMenu.css")).toExternalForm());
        MainMenu.PrimaryStage.setScene(alfa);
    }
    @FXML
    protected void mmEntered(MouseEvent event){
        MM.setStyle("-fx-text-fill: red;");
    }

    @FXML
    protected void SaEntered(MouseEvent event){
        Save.setStyle("-fx-text-fill: red;");
    }

    @FXML
    protected void SeEntered(MouseEvent event){
        Set.setStyle("-fx-text-fill: red;");
    }
    @FXML
    protected void mmExited(MouseEvent event){
        MM.setStyle("-fx-text-fill: white;");
    }

    @FXML
    protected void SaExited(MouseEvent event){
        Save.setStyle("-fx-text-fill: white;");
    }

    @FXML
    protected void SeExited(MouseEvent event){
        Set.setStyle("-fx-text-fill: white;");
    }
    @FXML
    protected void openSettings(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("SettingsMenu.fxml"));
        Scene gm = new Scene(fxmlLoader.load(), 1280, 720);
        MainMenu.PrimaryStage.setScene(gm);
        MainMenu.PrimaryStage.show();
    }
}
