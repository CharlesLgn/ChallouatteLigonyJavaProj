package com.controller;

import com.util.Utilitaires;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.invoke.LambdaConversionException;
import java.util.SimpleTimeZone;

public class NewUIController {


    @FXML
    private Label lbBienvenu;

    @FXML
    private Label lbTitre;

    @FXML
    private Button btFrToMorse;

    @FXML
    private Button btFrToLeet;

    @FXML
    private Button btMorseToFr;

    @FXML
    private Button btTradDirecte;

    @FXML
    Pane secPane;

    @FXML
    Pane pnZoneTravail;

    public void initialize() {

        String username = System.getProperty("user.name");
        this.lbBienvenu.setText("Bienvenue " + username);
    }


    public void btFrToMorseClick(MouseEvent event){
        this.lbTitre.setText("Français vers Morse");
        fadeout(this.pnZoneTravail);
        loadFxml(event,"..//gui/FrToMorse.fxml");
    }

    public void btFrToLeetClick(MouseEvent event){
        this.lbTitre.setText("Français vers L33t");
        fadeout(this.pnZoneTravail);
        loadFxml(event, "..//gui/FrToLeet.fxml");
    }

    public void btMorseToFrClick(MouseEvent event){
        this.lbTitre.setText("Morse vers français");
        fadeout(this.pnZoneTravail);
        loadFxml(event, "..//gui/AllToFr.fxml");
    }

    public void btTradDirecteClick(MouseEvent event){
        this.lbTitre.setText("Traduction directe");
        fadeout(this.pnZoneTravail);
        loadFxml(event, "..//gui/tradDirecte.fxml");
    }


    public void loadFxml (MouseEvent event, String form)  {
        try {
            pnZoneTravail.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource(form));
            this.pnZoneTravail.getChildren().add(newLoadedPane);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void fadeout (Pane pane){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(250), pane);
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
    }
}
