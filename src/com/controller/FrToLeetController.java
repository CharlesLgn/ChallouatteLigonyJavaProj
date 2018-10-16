package com.controller;

import com.util.Utilitaires;
import javafx.fxml.FXML;
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

import java.io.*;

import static com.method.TranslatorListe.romainToL33t;

public class FrToLeetController {

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
                    for (char lettre:ligne.toCharArray()) {
                        resmorse = resmorse + romainToL33t(lettre);
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
}
