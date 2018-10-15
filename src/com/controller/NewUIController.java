package com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.lang.invoke.LambdaConversionException;

public class NewUIController {


    @FXML
    private Label lbBienvenu;

    @FXML
    private Button btFrToMorse;

    @FXML
    Pane secPane;

    @FXML
    Pane pnZoneTravail;

    public void initialize() {

        String username = System.getProperty("user.name");
        this.lbBienvenu.setText("Bienvenue " + username);
    }


    public void btFrToMorseClick(MouseEvent event){
        loadFxml(event);
    }

    public void loadFxml (MouseEvent event)  {
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("..//gui/FrToMorse.fxml"));
            this.pnZoneTravail.getChildren().add(newLoadedPane);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
