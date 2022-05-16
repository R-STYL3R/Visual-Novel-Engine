package ru.rstyler.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    public Text closeButton;
    public Text startButton;
    @FXML
    protected void ColorChange(ActionEvent event){

    }
    @FXML
    protected void onExitButton(ActionEvent event) {
        System.exit(0);
    }
}