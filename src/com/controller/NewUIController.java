package com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        loadFxml(event,"..//gui/FrToMorse.fxml");
    }

    public void btFrToLeetClick(MouseEvent event){
        this.lbTitre.setText("Français vers L33t");
        loadFxml(event, "..//gui/FrToLeet.fxml");
    }

    public void btMorseToFrClick(MouseEvent event){
        this.lbTitre.setText("Morse vers français");
        loadFxml(event, "..//gui/AllToFr.fxml");
    }

    public void btTradDirecteClick(MouseEvent event){
        this.lbTitre.setText("Traduction directe");
        loadFxml(event, "..//gui/tradDirecte.fxml");
    }


    public void loadFxml (MouseEvent event, String form)  {
        try {
            this.pnZoneTravail.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource(form));
            this.pnZoneTravail.getChildren().add(newLoadedPane);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
