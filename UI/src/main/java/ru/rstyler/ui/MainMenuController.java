package ru.rstyler.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    protected void StartGame(ActionEvent event){
    startButton.setText("gay!");
    }
    @FXML
    protected void LoadGame(ActionEvent event){
        startButton.setText("you are gay");
    }
    @FXML
    protected void Settings(){}
    @FXML
    protected void onExitButton(ActionEvent event) {
        System.exit(0);
    }
}