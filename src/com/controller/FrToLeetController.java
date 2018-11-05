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
import resource.lang.typetrad.ButonName;
import resource.lang.Translate;
import resource.lang.typetrad.LabelName;
import resource.lang.typetrad.TitleName;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FrToLeetController implements Initializable {

    @FXML
    private GridPane panFrToL33t;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                translate();
            }
        }.start();
    }

    public void btChoixFichierLeetClick(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez un fichier texte");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(Utilitaires.getScene(event));
            if (file != null) {
                this.textboxCheminLeet.setText(file.getAbsolutePath());
            }
            this.btChoixFichierLeet.setDisable(true);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

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
            com.method.Alert.alertGenerique("Vérifiez qu'un fichier a été sélectionné");
        }
    }

    public void btExporterLeetClick(MouseEvent event){
        try {
            if (this.richtextboxLeet.getText() != null && !this.richtextboxLeet.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle("Choisissez un répertoire ou exporter votre traduction");
                File selectedDirectory = directorychooser.showDialog(Utilitaires.getScene(event));
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textboxExportLeet.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextboxLeet.getText());
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
                    com.method.Alert.alertGenerique("Vérifiez que vous avez bien sélectionné un fichier");
                }
            } else {
                com.method.Alert.alertGenerique("Vérifiez qu'une traduction a bien été sélectionné");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void btNouvelleTradLeetClick(MouseEvent event){
        this.textboxCheminLeet.clear();
        this.richtextboxLeet.clear();
        this.textboxExportLeet.clear();
        this.btTradLeet.setDisable(false);
        this.btChoixFichierLeet.setDisable(false);
    }

    private void translate(){
        Lang lang = MainJavaFx.getLangue();

        btChoixFichierLeet.setText(Translate.haveIt(ButonName.CHOOSE_FILE, lang.butonName));
        btTradLeet.setText(Translate.haveIt(ButonName.TRANSLATE, lang.butonName));
        btExporterLeet.setText(Translate.haveIt(ButonName.EXPORT, lang.butonName));
        btNouvelleTradLeet.setText(Translate.haveIt(ButonName.NEW_TRANSLATE, lang.butonName));
    }
}
