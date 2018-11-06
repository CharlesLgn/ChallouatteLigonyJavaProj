package com.controller;

import com.main.MainJavaFx;
import com.method.TranslatorHash;
import com.util.Utilitaires;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
import java.util.ResourceBundle;

public class FrToLeetController implements Initializable {

    @FXML
    private TextField textboxCheminLeet;

    @FXML
    private Button btChoixFichierLeet;

    @FXML
    private Button btTradLeet;

    @FXML
    private TextArea
    richtextboxLeet;

    @FXML private TextField
    textboxExportLeet;

    @FXML
    private Button btExporterLeet;

    @FXML
    private Button btNouvelleTradLeet;

    /**
     * Itialisation de la fenêtre, lance la traduction
     * @param location
     * @param resources
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

    /**
     * Ouvre une fenêtre de choix de fichier texte et place la sélection dans une textfield
     * @param event : Évènement clic souris
     */
    public void btChoixFichierLeetClick(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(Translate.haveIt(PopUpName.CHOOSE_FILE_TRAD, MainJavaFx.getLangue().popUp));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(Utilitaires.getScene(event));
            if (file != null) {
                this.textboxCheminLeet.setText(file.getAbsolutePath());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * Traduit le contenu du fichier texte et écrit le résultat dans la textarea
     * @param event : Évènement clic souris
     */
    public void btTradLeetClick(MouseEvent event){
        if(this.textboxCheminLeet.getText() != null && !this.textboxCheminLeet.getText().isEmpty()) {

            try {
                InputStream flux = new FileInputStream(this.textboxCheminLeet.getText());
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                String resmorse = "";
                while ((ligne=buff.readLine())!=null){
                    for (char lettre:ligne.toLowerCase().toCharArray()) {
                        resmorse = resmorse + TranslatorHash.romainToL33t(""+lettre);
                    }
                    this.richtextboxLeet.appendText(resmorse);
                }
                buff.close();
                this.btTradLeet.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_TRAD, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
        }
    }

    /**
     * Export la traduction vers un fichier texte sélectionné
     * @param event
     */
    public void btExporterLeetClick(MouseEvent event){
        try {
            if (this.richtextboxLeet.getText() != null && !this.richtextboxLeet.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle(Translate.haveIt(PopUpName.CHOOSE_FILE_EXPORT, MainJavaFx.getLangue().popUp));
                File selectedDirectory = directorychooser.showDialog(Utilitaires.getScene(event));
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textboxExportLeet.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextboxLeet.getText());
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
                    com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
                }
            } else {
                com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * Vide le formulaire
     * @param event : Évènement clic souris
     */
    public void btNouvelleTradLeetClick(MouseEvent event){
        this.textboxCheminLeet.clear();
        this.richtextboxLeet.clear();
        this.textboxExportLeet.clear();
    }

    /**
     * Traduction du texte des composants
     */
    private void translate(){
        Lang lang = MainJavaFx.getLangue();
        btChoixFichierLeet.setText(Translate.haveIt(ButonName.CHOOSE_FILE, lang.butonName));
        btTradLeet.setText(Translate.haveIt(ButonName.TRANSLATE, lang.butonName));
        btExporterLeet.setText(Translate.haveIt(ButonName.EXPORT, lang.butonName));
        btNouvelleTradLeet.setText(Translate.haveIt(ButonName.NEW_TRANSLATE, lang.butonName));
    }
}
