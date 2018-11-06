package com.controller;

import com.main.MainJavaFx;
import com.method.TranslatorHash;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.ButonName;
import resource.lang.typetrad.LabelName;

import java.net.URL;
import java.util.ResourceBundle;

import static com.method.TranslatorListe.romainToMorse;
import static com.util.Utilitaires.removeAccents;

public class tradDirecteController implements Initializable {

    @FXML
    private Label lblFr;

    @FXML
    private Label lblMorse;

    private char[] table = new char[1 << 15];
    private char[] tablesuppr = new char[1 << 15];

    @FXML
    private TextArea richtextbox_direct_fr;

    @FXML
    private TextArea richtextbox_direct_morse;

    @FXML
    private Button tradDirecteRecommencer;


    public void direct_type_morse(KeyEvent event){
        try {
            String carac = event.getText().toLowerCase();
            if(carac != null && !carac.equals("")) {
                carac = removeAccents(carac);
                richtextbox_direct_morse.setText("" + richtextbox_direct_morse.getText().substring(0, richtextbox_direct_morse.getText().length() - 1));
                richtextbox_direct_morse.appendText(carac);
                if(carac.matches("[A-z0-9 :;!?()&']")) {
                    // Ajoute en morse
                    String texte = richtextbox_direct_morse.getText();
                    char lastchar = richtextbox_direct_morse.getText().toCharArray()[richtextbox_direct_morse.getText().toCharArray().length - 1];
                    String morse = romainToMorse(lastchar);
                    //retire le dernier char
                    richtextbox_direct_morse.setText("" + richtextbox_direct_morse.getText().substring(0, richtextbox_direct_morse.getText().length() - 1));
                    richtextbox_direct_morse.appendText(morse + " ");
                    richtextbox_direct_fr.appendText(String.valueOf(TranslatorHash.morseToRomain(morse)));
                }
            }else{
     /*           if(!event.getText().equals("")){
                    richtextbox_direct_morse.setText("" + richtextbox_direct_morse.getText().substring(0, richtextbox_direct_morse.getText().length() - 1));
                }*/

                // Pour chaque élément split par espace, le traduire et l'append
                String code = event.getCode().getName();
                if(code == "Backspace" || code == "Delete"){
                    String [] tabmorse = this.richtextbox_direct_morse.getText().split(" ");
                    StringBuilder sb = new StringBuilder();
                    for (String item: tabmorse) {
                        if(TranslatorHash.morseToRomain(item) != null){
                            sb.append(TranslatorHash.morseToRomain(item));
                        }
                    }

                    this.richtextbox_direct_fr.clear();
                    this.richtextbox_direct_fr.appendText(sb.toString());
                }
            }
        }catch(Exception ex){}
    }


    public void direct_type_fr(KeyEvent event){
        try{
            String carac = event.getText().toLowerCase();
            if(carac != null && !carac.equals("")) {
                carac = removeAccents(carac);
                richtextbox_direct_fr.setText("" + richtextbox_direct_fr.getText().substring(0, richtextbox_direct_fr.getText().length() - 1));
                richtextbox_direct_fr.appendText(carac);
                this.table = this.richtextbox_direct_fr.getText().toCharArray();
                char lastchar = richtextbox_direct_fr.getText().toCharArray()[richtextbox_direct_fr.getText().toCharArray().length - 1];

                if(carac.matches("[A-z0-9 :;!?()&']")) {
                    // char lastchar = richtextbox_direct_fr.getText().toCharArray()[richtextbox_direct_fr.getText().toCharArray().length - 1];
                    String morse = TranslatorHash.romainToMorse("" + lastchar);
                    richtextbox_direct_morse.appendText(morse + " ");
                }
            }
            else{
           /*     if(!event.getText().equals("")){
                    richtextbox_direct_fr.setText("" + richtextbox_direct_fr.getText().substring(0, richtextbox_direct_fr.getText().length() - 1));
                }*/

                String code = event.getCode().getName();
                if(code == "Backspace" || code == "Delete"){
                    StringBuilder sb = new StringBuilder();
                    for (char item: this.richtextbox_direct_fr.getText().toCharArray()) {
                        sb.append(TranslatorHash.romainToMorse("" + item));
                    }

                    this.richtextbox_direct_morse.clear();
                    this.richtextbox_direct_morse.appendText(sb.toString());
                }
            }

        }
        catch(Exception ex) {

        }
    }

    public void tradDirecteRecommencerClick(MouseEvent event){
        this.richtextbox_direct_fr.clear();
        this.richtextbox_direct_morse.clear();
    }

    private void translate(){
        Lang lang = MainJavaFx.getLangue();

        lblFr.setText(Translate.haveIt(LabelName.WRITE_ROMAN, lang.label));
        lblMorse.setText(Translate.haveIt(LabelName.WRITE_MORSE, lang.label));
        tradDirecteRecommencer.setText(Translate.haveIt(ButonName.RESTART, lang.butonName));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                translate();
            }
        }.start();
    }
}
