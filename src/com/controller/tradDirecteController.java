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

    @FXML
    private TextArea richtextbox_direct_fr;

    @FXML
    private TextArea richtextbox_direct_morse;

    @FXML
    private Button tradDirecteRecommencer;

    /**
     * Traduit directement les entrées utilisateur dans la textarea et recopie les entrées dans l'autre textarea, gère aussi la suppression des deux côtés
     * @param event : Évènement entrée clavier relâché
     */
    public void direct_type_morse(KeyEvent event){
        try {
            String carac = event.getText().toLowerCase();
            if (!carac.equals("")) {
                carac = removeAccents(carac);
                if (carac.matches("[A-z0-9 :;!?()&',.\'=+_\"$@]")) {
                    richtextbox_direct_fr.appendText(carac);
                    richtextbox_direct_morse.setText("" + richtextbox_direct_morse.getText().substring(0, richtextbox_direct_morse.getText().length() - 1));
                    richtextbox_direct_morse.appendText(carac);
                    // Ajoute en morse
                    char lastchar = richtextbox_direct_morse.getText().toCharArray()[richtextbox_direct_morse.getText().toCharArray().length - 1];
                    String morse = romainToMorse(lastchar);
                    //retire le dernier char
                    richtextbox_direct_morse.setText("" + richtextbox_direct_morse.getText().substring(0, richtextbox_direct_morse.getText().length() - 1));
                    richtextbox_direct_morse.appendText(morse + " ");
                } else {
                    deniedMorse(carac);
                }
            } else {
                String code = event.getCode().getName();
                if (code.equals("Backspace") || code.equals("Delete")) {
                    String[] tabmorse = this.richtextbox_direct_morse.getText().split(" ");
                    StringBuilder sb = new StringBuilder();
                    for (String item : tabmorse) {
                        if (TranslatorHash.morseToRomain(item) != null) {
                            sb.append(TranslatorHash.morseToRomain(item));
                        }
                    }

                    this.richtextbox_direct_fr.clear();
                    this.richtextbox_direct_fr.appendText(sb.toString());
                }
            }
        }catch(Exception ignored){}
    }

    public void deniedMorse (String carac){
        String newtext = this.richtextbox_direct_morse.getText().replace(carac, "");
        this.richtextbox_direct_morse.clear();
        this.richtextbox_direct_morse.appendText(newtext);
    }

    public void deniedFr (String carac){
        String newtext = this.richtextbox_direct_fr.getText().replace(carac, "");
        this.richtextbox_direct_fr.clear();
        this.richtextbox_direct_fr.appendText(newtext);
    }

    /**
     * Traduit directement les entrées utilisateur dans l'autre textarea et écrit dans la textarea actuelle les entrées utilisateur, gère aussi la suppression des deux côtés
     * @param event : Évènement entrée clavier relâché
     */
    public void direct_type_fr(KeyEvent event){
        try {
            String carac = event.getText().toLowerCase();
                if (!carac.equals("")) {
                    carac = removeAccents(carac);
                    if (carac.matches("[A-z0-9 :;!?()&',.\'=+_\"$@]")) {
                        richtextbox_direct_fr.setText("" + richtextbox_direct_fr.getText().substring(0, richtextbox_direct_fr.getText().length() - 1));
                        richtextbox_direct_fr.appendText(carac);
                        char lastchar = richtextbox_direct_fr.getText().toCharArray()[richtextbox_direct_fr.getText().toCharArray().length - 1];
                        String morse = TranslatorHash.romainToMorse("" + lastchar);
                        richtextbox_direct_morse.appendText(morse + " ");
                    } else {
                        deniedFr(carac);
                    }
                } else {
                    String code = event.getCode().getName();
                    if (code.equals("Backspace") || code.equals("Delete")) {
                        StringBuilder sb = new StringBuilder();
                        for (char item : this.richtextbox_direct_fr.getText().toCharArray()) {
                            if (("" + item).matches("[A-z0-9 :;!?()&',.\'=+_\"$@]")) {
                                sb.append(TranslatorHash.romainToMorse("" + item));
                            }
                        }

                        this.richtextbox_direct_morse.clear();
                        this.richtextbox_direct_morse.appendText(sb.toString());
                    }
                }
            }
        catch(Exception ignored) {}
    }

    /**
     * Vide le formulaire
     */
    public void tradDirecteRecommencerClick(){
        this.richtextbox_direct_fr.clear();
        this.richtextbox_direct_morse.clear();
    }

    /**
     * Traduit les composants
     */
    private void translate(){
        Lang lang = MainJavaFx.getLangue();

        lblFr.setText(Translate.haveIt(LabelName.WRITE_ROMAN, lang.label));
        lblMorse.setText(Translate.haveIt(LabelName.WRITE_MORSE, lang.label));
        tradDirecteRecommencer.setText(Translate.haveIt(ButonName.RESTART, lang.butonName));
    }

    /**
     * Lance la traduction des utilisateurs
     * @param location : not used
     * @param resources : not used
     */
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
