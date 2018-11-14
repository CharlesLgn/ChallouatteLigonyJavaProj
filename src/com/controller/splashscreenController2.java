package com.controller;

import com.main.MainJavaFx;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.LabelName;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class splashscreenController2 implements Initializable {

    @FXML
    ProgressBar progressbar;
    @FXML
    GridPane panPropos;

    @FXML
    StackPane panParent;

    @FXML
    Label identifiant;

    /**
     * Initialisation de la fenêtre, lance la traduction en fonction de la langue sélectionnée
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                translate();
            }
        }.start();

        BackgroundImage myBI;
        try{
            myBI= new BackgroundImage(new Image("/resource/Images/back1.jpg",1200,600,true,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, new BackgroundPosition(Side.LEFT, -125, false, Side.TOP, -125, false),
                    BackgroundSize.DEFAULT);
            panPropos.setBackground(new Background(myBI));
        } catch (Exception e){
            System.err.println(e);
        }

        //progressbar.setOpacity(0.75);
        new Thread(new SplashScreen()).start();
    }

    /**
     * Traduction des composants
     */
    private void translate() {
        Lang lang = MainJavaFx.getLangue();

        MainJavaFx.getPrimaryStage().setTitle(Translate.haveIt(LabelName.TITLE, lang.label));
        identifiant.setText(Translate.haveIt(LabelName.WELCOME, lang.label) + " " + System.getProperty("user.name"));
    }

    class SplashScreen extends Task {

        @Override
        public Object call() throws IOException, InterruptedException{
            Thread.sleep(3000);
            Parent root = FXMLLoader.load(getClass().getResource("../gui/NewUI.fxml"));

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    MainJavaFx.loadTrad();

                    Stage stage = new Stage();
                    stage.setTitle("Traducteur");
                    stage.initStyle(StageStyle.UNDECORATED);

                    assert root != null;
                    Scene scene = new Scene(root, 1280, 720);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image("/resource/Images/icon.png"));
                    scene.getStylesheets().add(getClass().getResource("..//gui/css/NewUICSS.css").toExternalForm());
                    stage.show();
                    MainJavaFx.setPrimaryStage(stage);
                    ((Stage) panParent.getScene().getWindow()).close();
                }
            });
            return null;
        }
    }

}
