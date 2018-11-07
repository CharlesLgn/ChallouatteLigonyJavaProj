package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class splashscreenController implements Initializable {

    @FXML
    ProgressBar progressbar;

    @FXML
    Label identifiant;

    public void initialize(URL location, ResourceBundle resources) {

        this.identifiant.setText("Bienvenue " +  System.getProperty("user.name"));


    }
}
