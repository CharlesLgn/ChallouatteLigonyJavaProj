package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class proposController implements Initializable{
    @FXML
    private GridPane panClasse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackgroundImage myBI= new BackgroundImage(new Image("./resource/Images/back8.jpg",720,500,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, new BackgroundPosition(Side.LEFT, 100, true, Side.TOP, 0, true),
                BackgroundSize.DEFAULT);
//then you set to your node
        panClasse.setBackground(new Background(myBI));
    }
}