package com.controller;

import com.main.MainJavaFx;
import com.method.trad.TranslatorHash;
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

import static com.method.autre.Utilitaires.removeAccents;

public class tradDirecteController implements Initializable {

    String oldText = "";

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
            String str = richtextbox_direct_fr.getText();
                if (oldText.length()+1 == str.length() && oldText.equalsIgnoreCase(str.substring(0, str.length()-1))){
                    if (!carac.equals("")) {
                        carac = removeAccents(carac);
                        if (event.getCode().getName().equalsIgnoreCase("Enter")) {
                            this.richtextbox_direct_morse.appendText("\n");
                        }else if (carac.matches("[A-z0-9 :;!?()&',.\'=+_\"$@]")) {
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
                                if (item == '\n'){
                                    sb.append('\n');
                                }else if (("" + item).matches("[A-z0-9 :;!?()&',.\'=+_\"$@]")) {
                                    sb.append(TranslatorHash.romainToMorse("" + item));
                                }
                            }

                            this.richtextbox_direct_morse.clear();
                            this.richtextbox_direct_morse.appendText(sb.toString());
                        }
                    }
                } else {
                    this.richtextbox_direct_morse.setText(toutRetraduir(str));
                }
                oldText = richtextbox_direct_fr.getText();
            }
        catch(Exception ignored) {}
    }

    private String toutRetraduir(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < str.length() ; i++ ){
            String carac = removeAccents(""+str.charAt(i));
            if (carac.equalsIgnoreCase("\n")) {
                sb.append("\n");
            }else if (carac.matches("[A-z0-9 :;!?()&',.\'=+_\"$@]")) {
                sb.append(TranslatorHash.romainToMorse(""+str.charAt(i)))
                        .append(" ");
            } else {
                deniedFr(carac);
            }
        }
        return sb.toString();
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
