package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import static com.method.TranslatorListe.morseToRomain;
import static com.method.TranslatorListe.romainToMorse;
import static com.util.Utilitaires.removeAccents;

public class tradDirecteController {

    @FXML
    private TextArea richtextbox_direct_fr;

    @FXML
    private TextArea richtextbox_direct_morse;

    @FXML
    private Button tradDirecteRecommencer;


    public void direct_type_morse(KeyEvent event){
        try {
            String carac = event.getText();
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
                richtextbox_direct_morse.appendText(morse);
                richtextbox_direct_fr.appendText(String.valueOf(morseToRomain(morse)));
            }else{
                if(!event.getText().equals("")){
                    richtextbox_direct_morse.setText("" + richtextbox_direct_morse.getText().substring(0, richtextbox_direct_morse.getText().length() - 1));
                }

                // Ajouter la suppression des caractères de l'autre textarea

            }
        }catch(Exception ex){}
    }


    public void direct_type_fr(KeyEvent event){
        try{
            String carac = event.getText();
            carac = removeAccents(carac);
            richtextbox_direct_fr.setText("" + richtextbox_direct_fr.getText().substring(0, richtextbox_direct_fr.getText().length() - 1));
            richtextbox_direct_fr.appendText(carac);
            if(carac.matches("[A-z0-9 :;!?()&']")) {
                char lastchar = richtextbox_direct_fr.getText().toCharArray()[richtextbox_direct_fr.getText().toCharArray().length - 1];
                String morse = romainToMorse(lastchar);
                richtextbox_direct_morse.appendText(morse);
            }
            else{
                if(!event.getText().equals("")){
                    richtextbox_direct_fr.setText("" + richtextbox_direct_fr.getText().substring(0, richtextbox_direct_fr.getText().length() - 1));
                }

                // Ajouter la suppression des caractères de l'autre textarea
                // Utiliser un last indexof
                String code = event.getCode().getName();
                if(code == "Backspace"){
                    String plop = this.richtextbox_direct_fr.getText();
                    char last = plop.charAt(this.richtextbox_direct_fr.getText().length() - 1);
                    String morseAchercher = romainToMorse(last);
                    int morseAdelete = this.richtextbox_direct_morse.getText().lastIndexOf(morseAchercher);
                    String stringWithoutmorseAdelete = this.richtextbox_direct_morse.getText().substring(0,morseAdelete);
                    this.richtextbox_direct_morse.clear();
                    this.richtextbox_direct_morse.appendText(stringWithoutmorseAdelete);

                }

            }
        }catch(Exception ex){

        }
    }



    public void tradDirecteRecommencerClick(MouseEvent event){
        this.richtextbox_direct_fr.clear();
        this.richtextbox_direct_morse.clear();
    }


}
