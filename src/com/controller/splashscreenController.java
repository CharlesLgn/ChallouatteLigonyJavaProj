package com.controller;

import com.main.MainJavaFx;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class splashscreenController implements Initializable {

    @FXML
    ProgressBar progressbar;

    @FXML
    Label identifiant;
    @FXML
    Label panLoad;

    public void initialize(URL location, ResourceBundle resources) {
        this.identifiant.setText("Bienvenue " +  System.getProperty("user.name"));
        MainJavaFx.loadTrad();
        //((Stage)panLoad.getScene().getWindow()).close();

    }

}
