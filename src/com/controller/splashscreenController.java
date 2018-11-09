package com.controller;

import com.main.MainJavaFx;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.LabelName;

import java.net.URL;
import java.util.ResourceBundle;

public class splashscreenController implements Initializable {

    @FXML
    ProgressBar progressbar;

    @FXML
    GridPane panPropos;

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
            myBI= new BackgroundImage(new Image("/resource/Images/back1.jpg",1800,1000,true,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, new BackgroundPosition(Side.LEFT, -100, false, Side.TOP, -125, false),
                    BackgroundSize.DEFAULT);
            panPropos.setBackground(new Background(myBI));
        } catch (Exception e){
            System.err.println(e);
        }
        MainJavaFx.loadTrad();
        //((Stage)panLoad.getScene().getWindow()).close();
    }

    /**
     * Traduction des composants
     */
    private void translate() {
        Lang lang = MainJavaFx.getLangue();

        MainJavaFx.getPrimaryStage().setTitle(Translate.haveIt(LabelName.TITLE, lang.label));
        identifiant.setText(Translate.haveIt(LabelName.WELCOME, lang.label) + " " + System.getProperty("user.name"));
    }

}
