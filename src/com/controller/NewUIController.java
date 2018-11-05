package com.controller;

import com.util.Utilitaires;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import com.main.MainJavaFx;
import javafx.animation.AnimationTimer;
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
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.langage.DE;
import resource.lang.langage.EN;
import resource.lang.langage.FR;
import resource.lang.langage.RU;
import resource.lang.typetrad.LabelName;
import resource.lang.typetrad.TitleName;

public class NewUIController {


    @FXML
    private Label lbBienvenu;
    private String username = System.getProperty("user.name");
    private int titre = -1;

    @FXML
    private Label lblTranslate;

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
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                translate();
            }
        }.start();
    }


    public void btFrToMorseClick(MouseEvent event) {
        this.lbTitre.setText("Français vers Morse");
        fadeout(this.pnZoneTravail);
        titre = TitleName.LANGUAGE_TO_MORSE;
        loadFxml(event, "..//gui/FrToMorse.fxml");
    }

    public void btFrToLeetClick(MouseEvent event) {
        this.lbTitre.setText("Français vers L33t");
        fadeout(this.pnZoneTravail);
        titre = TitleName.LANGUAGE_TO_L33T;
        loadFxml(event, "..//gui/FrToLeet.fxml");
    }

    public void btMorseToFrClick(MouseEvent event) {
        this.lbTitre.setText("Morse vers français");
        fadeout(this.pnZoneTravail);
        titre = TitleName.MORSE_TO_LANGUAGE;
        loadFxml(event, "..//gui/AllToFr.fxml");
    }

    public void btTradDirecteClick(MouseEvent event) {
        this.lbTitre.setText("Traduction directe");
        fadeout(this.pnZoneTravail);
        titre = TitleName.DIRECT_TRANSLATE;
        loadFxml(event, "..//gui/tradDirecte.fxml");
    }


    public void loadFxml(MouseEvent event, String form) {
        try {
            pnZoneTravail.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource(form));
            this.pnZoneTravail.getChildren().add(newLoadedPane);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void fadeout(Pane pane) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(250), pane);
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
    }

    private void translate() {
        Lang lang = MainJavaFx.getLangue();

        if (titre != -1) {
            lbTitre.setText(Translate.haveIt(titre, lang.titleName));
        }
        btFrToMorse.setText(Translate.haveIt(TitleName.LANGUAGE_TO_MORSE, lang.titleName));
        btFrToLeet.setText(Translate.haveIt(TitleName.LANGUAGE_TO_L33T, lang.titleName));
        btMorseToFr.setText(Translate.haveIt(TitleName.MORSE_TO_LANGUAGE, lang.titleName));
        btTradDirecte.setText(Translate.haveIt(TitleName.DIRECT_TRANSLATE, lang.titleName));

        lbBienvenu.setText(Translate.haveIt(LabelName.WELCOME, lang.label) + " " + username);
        lblTranslate.setText(Translate.haveIt(LabelName.TITLE, lang.label));
    }

    public void toFr() {
        MainJavaFx.setLangue(new FR());
    }

    public void toDe() {
        MainJavaFx.setLangue(new DE());
    }

    public void toRu() {
        MainJavaFx.setLangue(new RU());
    }

    public void toEn() {
        MainJavaFx.setLangue(new EN());
    }
}

