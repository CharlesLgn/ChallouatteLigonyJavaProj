package com.controller;

import com.main.MainJavaFx;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.DisclimerName;
import resource.lang.typetrad.LabelName;

import java.net.URL;
import java.util.ResourceBundle;

public class ProposController implements Initializable{
    @FXML
    private GridPane panClasse;

    @FXML
    private Label lblBuild;
    @FXML
    private Label lblRealise;
    @FXML
    private Label lblCadre;
    @FXML
    private Label lblTitle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackgroundImage myBI= new BackgroundImage(new Image("./src/resource/Images/back1.jpg",1280,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, new BackgroundPosition(Side.LEFT, -120, true, Side.TOP, -50, false),
                BackgroundSize.DEFAULT);
//then you set to your node
        panClasse.setBackground(new Background(myBI));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                translate();
            }
        }.start();
    }

    private void translate() {
        Lang lang = MainJavaFx.getLangue();

        lblBuild.setText(Translate.haveIt(DisclimerName.LBL_BUILD, lang.disclimer));
        lblCadre.setText(Translate.haveIt(DisclimerName.LBL_CADRE, lang.disclimer));
        lblRealise.setText(Translate.haveIt(DisclimerName.LBL_REALISE, lang.disclimer));
        lblTitle.setText(Translate.haveIt(LabelName.TITLE, lang.label));
    }
}