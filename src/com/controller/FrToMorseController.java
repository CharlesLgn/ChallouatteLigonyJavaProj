package com.controller;

import com.main.MainJavaFx;
import com.method.autre.JouerSon;
import com.method.trad.TranslatorHash;
import com.method.autre.Utilitaires;
import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.ButonName;
import resource.lang.typetrad.PopUpName;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.method.trad.TranslatorListe.romainToMorse;

public class FrToMorseController implements Initializable {

    @FXML
    Button btCheminMorse;

    @FXML
    Button btJouerSonFrToMorse;

    @FXML
    TextField texBoxCheminFrToMorse;

    @FXML
    TextField textboxExporterFrToMorse;

    @FXML
    TextArea richTextboxFrToMorse;

    @FXML
    Button btTradFrToMorse;

    @FXML
    Button btExporterFrToMorse;

    @FXML
    Button btNouvelleTrad;

    /**
     * Permet de sélectionner un fichier texte et d'afficher la sélection dans une textfield
     * @param event : Évènement clic souris
     */
    public void btCheminMorseClick (MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(Translate.haveIt(PopUpName.CHOOSE_FILE_TRAD, MainJavaFx.getLangue().popUp));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(Utilitaires.getScene(event));
            if (file != null) {
                this.texBoxCheminFrToMorse.setText(file.getAbsolutePath());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * Traduit le contenu du fichier et affiche le résultat dans la textarea
     */
    public void btTradFrToMorseClick(){
        richTextboxFrToMorse.clear();
        if(this.texBoxCheminFrToMorse.getText() != null && !this.texBoxCheminFrToMorse.getText().isEmpty()) {

            try {
                InputStream flux = new FileInputStream(this.texBoxCheminFrToMorse.getText());
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                StringBuilder resmorse = new StringBuilder();
                while ((ligne = buff.readLine())!=null){
                    resmorse= new StringBuilder();
                    for (char lettre:ligne.toLowerCase().toCharArray()) {
                        if(!Objects.equals(romainToMorse(lettre), "  ")){
                            resmorse.append(romainToMorse(lettre)).append(" ");
                        } else{
                            resmorse.append(TranslatorHash.romainToMorse("" + lettre));
                        }
                    }
                    this.richTextboxFrToMorse.appendText(resmorse.toString().trim());
                    this.richTextboxFrToMorse.appendText("\n");
                }
                buff.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.autre.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_NO_FILE_SELECTED, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
        }
    }

    /**
     * Permet d'écouter la traduction en morse
     */
    public void btJouerSonFrToMorseClick() {
        String str;
        str = this.richTextboxFrToMorse.getText();
        if (str != null && !str.isEmpty()){

            Task<Void> task = new Task<Void>() {

                // Implement required call() method
                @Override
                protected Void call() {
                    // Add delay code from initial attempt
                    try {
                        JouerSon.jouerson(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };
            Thread t = new Thread(task);
            t.setDaemon(true);
            t.start();
        }else{
            com.method.autre.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_PLAY_TRAD, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
        }
    }

    /**
     * Permet d'exporter la traduction dans le fichier texte sélectionné
     * @param event : Évènement clic souris
     */
    public void btExporterFrToMorseClick(MouseEvent event){
        try {
            if (this.richTextboxFrToMorse.getText() != null && !this.richTextboxFrToMorse.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle("Choisissez un répertoire ou exporter votre traduction");
                File selectedDirectory = directorychooser.showDialog(Utilitaires.getScene(event));
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textboxExporterFrToMorse.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richTextboxFrToMorse.getText());
                    fichierexportwrite.close();
                    //region messagebox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(Translate.haveIt(PopUpName.POP_UP_SUCCES_TITTLE, MainJavaFx.getLangue().popUp));
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setHeaderText(Translate.haveIt(PopUpName.POP_UP_SUCCES_NAME, MainJavaFx.getLangue().popUp));
                    alert.setContentText(Translate.haveIt(PopUpName.POP_UP_SUCCES_DESC, MainJavaFx.getLangue().popUp));
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
                    alert.showAndWait();
                    //endregion
                } else {
                    com.method.autre.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
                }
            } else {
                com.method.autre.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * Vide le formualaire
     */
    public void btNouvelleTradClick(){
        this.texBoxCheminFrToMorse.clear();
        this.richTextboxFrToMorse.clear();
        this.textboxExporterFrToMorse.clear();
    }

    /**
     * Traduction des composants
     */
    private void translate(){
        Lang lang = MainJavaFx.getLangue();
        btCheminMorse.setText(Translate.haveIt(ButonName.CHOOSE_FILE, lang.butonName));
        btTradFrToMorse.setText(Translate.haveIt(ButonName.TRANSLATE, lang.butonName));
        btJouerSonFrToMorse.setText(Translate.haveIt(ButonName.PLAY_TRANSLATE, lang.butonName));
        btExporterFrToMorse.setText(Translate.haveIt(ButonName.EXPORT, lang.butonName));
        btNouvelleTrad.setText(Translate.haveIt(ButonName.NEW_TRANSLATE, lang.butonName));
    }

    /**
     * Initialisation de la fenêtre, lance la traduction des composants
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
