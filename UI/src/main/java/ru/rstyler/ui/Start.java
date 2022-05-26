package ru.rstyler.ui;

import javafx.animation.FadeTransition;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;
import org.w3c.dom.events.MouseEvent;

import java.util.Timer;
import java.util.TimerTask;

import static com.sun.javafx.font.PrismFontFactory.isEmbedded;

public class Start extends Preloader {
    ProgressBar bar;
    Stage stage;
    ImageView pre = new ImageView();
    private Scene createPreloaderScene() {

        Image preload = new Image(String.valueOf(Start.class.getResource("images/preloadScreen.png")));
        bar = new ProgressBar();
        pre.setImage(preload);
        BorderPane alfa = new BorderPane();
        alfa.getChildren().addAll(pre);
        alfa.setCenter(bar);
        return new Scene(alfa, 1280, 720);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress());
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
            MainMenu alfa = new MainMenu();
            try {
                alfa.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
    }
