package com.controller;

import com.method.JouerSon;
import com.util.Utilitaires;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.method.TranslatorListe.*;
import static com.util.Utilitaires.removeAccents;


public class ControllerMorse extends Window {

    //region Partie Morse

    @FXML
    private TabPane fenetre;
    @FXML
    private TextField textbox_chemin_morse;
    @FXML
    private Button bt_chemin_morse;
    @FXML
    private TextArea richtextbox_traduction_morse;
    @FXML
    private Button bt_jouerson_morse;
    @FXML
    private Button bt_exporter_morse;
    @FXML
    private Button bt_nouvelletrad_morse;
    @FXML
    private Button bt_traduire_morse;
    @FXML
    private TextField textbox_cheminexport_morse;

    private String str;


    /**
     * Joue le son morse
     * @param event
     * @throws Exception
     */
     public void btjouersonmorse(MouseEvent event){
         str = this.richtextbox_traduction_morse.getText();

         final Service<Void> jouerSonService = new Service<Void>() {
             @Override
             protected Task<Void> createTask() {
                 return new Task<Void>() {
                     @Override
                     protected Void call() throws Exception {
                         try {
                             JouerSon.jouerson(str);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                         return null;
                     }
                 };
             }
         };

         jouerSonService.start();
     }

    /**
     * Sélection du fichier à traduire
     * @param event
     */
    public void btcheminclick(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez un fichier texte");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(this);
            if (file != null) {
                this.textbox_chemin_morse.setText(file.getAbsolutePath());
            }
            this.bt_chemin_morse.setDisable(true);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    /**
     * Déclenche la traduction et affiche le résultat dans la textaera
     * @param event
     */
    public void bttradclick(MouseEvent event){
        if(this.textbox_chemin_morse.getText() != null && !this.textbox_chemin_morse.getText().isEmpty()) {

            try {
                InputStream flux = new FileInputStream(this.textbox_chemin_morse.getText());
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                String resmorse = "";
                while ((ligne=buff.readLine())!=null){
                        for (char lettre:ligne.toCharArray()) {
                            String ajoutlettre = null;
                            if(romainToMorse(lettre) != "  "){
                                resmorse = resmorse + romainToMorse(lettre) + " ";
                            }else{
                                resmorse = resmorse + romainToMorse(lettre);
                            }
                    }
                    this.richtextbox_traduction_morse.appendText(resmorse.trim());
                                }
                buff.close();
                this.bt_traduire_morse.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
            else{
            com.method.Alert.alertGenerique("Something here to explain");
        }
    }

    /**
     * Gère le bouton de l'export du texte traduit dans une fichier
     * @param event
     */
    public void btexportmorse(MouseEvent event){
        try {
            if (this.textbox_cheminexport_morse.getText() != null && !this.textbox_cheminexport_morse.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle("Choisissez un répertoire ou exporter votre traduction");
                File selectedDirectory = directorychooser.showDialog(this);
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textbox_cheminexport_morse.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextbox_traduction_morse.getText());
                    fichierexportwrite.close();
                    //region messagebox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Succès");
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setHeaderText("Export");
                    alert.setContentText("La traduction a été exportée");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
                    alert.showAndWait();
                    //endregion
                } else {
                    com.method.Alert.alertGenerique("Something here to explain");
                }
            } else {
                com.method.Alert.alertGenerique("Something here to explain");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * Réinitialise les composants
     * @param event
     */
    public void btnewtrad(MouseEvent event){
        this.textbox_chemin_morse.clear();
        this.richtextbox_traduction_morse.clear();
        this.textbox_cheminexport_morse.clear();
        this.bt_traduire_morse.setDisable(false);
        this.bt_chemin_morse.setDisable(false);
    }

    //endregion

    //region Partie Leet

    @FXML
    private TextField textbox_chemin_leet;
    @FXML
    private Button bt_chemin_leet;
    @FXML
    private Button bt_traduire_leet;
    @FXML
    private TextArea richtextbox_traduction_leet;
    @FXML
    private TextField textbox_cheminexport_leet;
    @FXML
    private Button bt_exporter_leet;
    @FXML
    private Button bt_nouvelletrad_leet;

    /**
     *
     * @param event
     */
    public void btcheminclickleet(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez un fichier texte");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(this);
            if (file != null) {
                this.textbox_chemin_leet.setText(file.getAbsolutePath());
            }
            this.bt_chemin_leet.setDisable(true);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void bttradclickleet(MouseEvent event){
        if(this.textbox_chemin_leet.getText() != null && !this.textbox_chemin_leet.getText().isEmpty()) {

            try {
                InputStream flux = new FileInputStream(this.textbox_chemin_leet.getText());
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                String resmorse = "";
                while ((ligne=buff.readLine())!=null){
                    for (char lettre:ligne.toCharArray()) {
                        resmorse = resmorse + romainToL33t(lettre);
                    }
                    this.richtextbox_traduction_leet.appendText(resmorse);
                }
                buff.close();
                this.bt_traduire_leet.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.Alert.alertGenerique("Something here to explain");
        }
    }

    public void btexportleet(MouseEvent event){

        try {
            if (this.textbox_cheminexport_leet.getText() != null && !this.textbox_cheminexport_leet.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle("Choisissez un répertoire ou exporter votre traduction");
                File selectedDirectory = directorychooser.showDialog(this);
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textbox_cheminexport_leet.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextbox_traduction_leet.getText());
                    fichierexportwrite.close();
                    //region messagebox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Succès");
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setHeaderText("Export");
                    alert.setContentText("La traduction a été exportée");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
                    alert.showAndWait();
                    //endregion
                } else {
                    com.method.Alert.alertGenerique("Something here to explain");
                }
            } else {
                com.method.Alert.alertGenerique("Something here to explain");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void btnewtradleet(MouseEvent event){
        this.textbox_chemin_leet.clear();
        this.richtextbox_traduction_leet.clear();
        this.textbox_cheminexport_leet.clear();
        this.bt_traduire_leet.setDisable(false);
        this.bt_chemin_leet.setDisable(false);
    }

    //endregion

    //region Partie traduire vers français

    @FXML
    private TextField textbox_chemin_transfr;
    @FXML
    private Button bt_chemin_transfr;
    @FXML
    private ComboBox combobox_transfr;
    @FXML
    private Button bt_traduire_transfr;
    @FXML
    private TextArea richtextbox_traduction_transfr;
    @FXML
    private TextField textbox_cheminexport_transfr;
    @FXML
    private Button bt_exporter_transfr;
    @FXML
    private Button bt_nouvelletrad_transfr;
    @FXML
    private TabPane tabpaneprincipale;

    public void initialize() {

        // Évènement déclenché lors d'un changement d'onglet : les champs sont vidés

        tabpaneprincipale.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                        // Lors du changement d'onglet, on clear.

                        textbox_chemin_morse.clear();
                        richtextbox_traduction_morse.clear();
                        textbox_cheminexport_morse.clear();
                        textbox_chemin_leet.clear();
                        richtextbox_traduction_leet.clear();
                        textbox_cheminexport_leet.clear();
                        textbox_chemin_transfr.clear();
                        richtextbox_traduction_transfr.clear();
                        textbox_cheminexport_transfr.clear();
                        richtextbox_direct_fr.clear();
                        richtextbox_direct_morse.clear();
                    }
                }
        );

    }


    public void btcheminclicktransfr(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez un fichier texte");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(this);
            if (file != null) {
                this.textbox_chemin_transfr.setText(file.getAbsolutePath());
            }
            this.bt_chemin_transfr.setDisable(true);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void bttradclicktransfr(MouseEvent event){
        if(this.textbox_chemin_transfr.getText() != null && !this.textbox_chemin_transfr.getText().isEmpty()) {

            try {
                StringBuilder sb = new StringBuilder();
                InputStream flux = new FileInputStream(this.textbox_chemin_transfr.getText());
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                while ((ligne=buff.readLine())!=null){
                    String[] listeMotsMorse = ligne.split("   ");

                    ArrayList listemorse = new ArrayList<>();
                    for (String item:listeMotsMorse) {
                        String[] lettres = item.split(" ");
                        for(String lettre : lettres){
                            sb.append(morseToRomain(lettre));
                        }
                        sb.append(" ");
                    }

                    this.richtextbox_traduction_transfr.appendText(sb.toString().trim());
                }
                buff.close();
                this.bt_traduire_transfr.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.Alert.alertGenerique("Something here to explain");
        }
    }
    public void btexporttransfr(MouseEvent event){
        try {
            if (this.textbox_cheminexport_transfr.getText() != null && !this.textbox_cheminexport_transfr.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle("Choisissez un répertoire ou exporter votre traduction");
                File selectedDirectory = directorychooser.showDialog(this);
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textbox_cheminexport_transfr.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextbox_traduction_transfr.getText());
                    fichierexportwrite.close();
                    //region messagebox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Succès");
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setHeaderText("Export");
                    alert.setContentText("La traduction a été exportée");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
                    alert.showAndWait();
                    //endregion
                } else {
                    //region messagebox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur");
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setHeaderText("Chemin du répertoire");
                    alert.setContentText("Sélectionnez un répertoire valide");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
                    alert.showAndWait();
                    //endregion
                }
            } else {
                //region messagebox
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erreur");
                alert.initStyle(StageStyle.DECORATED);
                alert.setHeaderText("Nom du fichier");
                alert.setContentText("Entrez un nom de fichier valide");
                ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
                alert.showAndWait();
                //endregion
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void btnewtradtransfr(MouseEvent event){
        this.textbox_chemin_transfr.clear();
        this.richtextbox_traduction_transfr.clear();
        this.textbox_cheminexport_transfr.clear();
        this.bt_traduire_transfr.setDisable(false);
        this.bt_chemin_transfr.setDisable(false);
    }

    // endregion

    // region : Traduction directe

    @FXML
    private TextArea richtextbox_direct_fr;
    @FXML
    private TextArea richtextbox_direct_morse;


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

    public void tradirecte_clearclick(MouseEvent event){
        this.richtextbox_direct_fr.clear();
        this.richtextbox_direct_morse.clear();
    }








    // endregion
}
