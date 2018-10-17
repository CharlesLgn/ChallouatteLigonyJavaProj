package com.controller;

import com.method.TranslatorHash;
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
import java.util.ArrayList;

import static com.method.TranslatorListe.morseToRomain;

public class AllToFrController {

    @FXML
    private TextField textboxAllToFr;

    @FXML
    private Button btChoixAllToFr;

    @FXML
    private Button btTradAllToFr;

    @FXML
    private TextArea richtextboxAllToFr;

    @FXML
    private TextField textboxExportAllToFr;

    @FXML
    private Button btExportAllToFr;

    @FXML
    private Button btNouvelleTradAllToFr;

    public void btChoixAllToFrClick(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez un fichier texte");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(Utilitaires.getScene(event));
            if (file != null) {
                this.textboxAllToFr.setText(file.getAbsolutePath());
            }
            this.btChoixAllToFr.setDisable(true);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void btTradAllToFrClick(MouseEvent event){
        if(this.textboxAllToFr.getText() != null && !this.textboxAllToFr.getText().isEmpty()) {

            try {
                StringBuilder sb = new StringBuilder();
                InputStream flux = new FileInputStream(this.textboxAllToFr.getText());
                InputStreamReader lecture = new InputStreamReader(flux);
                BufferedReader buff=new BufferedReader(lecture);
                String ligne;
                while ((ligne=buff.readLine())!=null){
                    String[] listeMotsMorse = ligne.split("   ");

                    ArrayList listemorse = new ArrayList<>();
                    for (String item:listeMotsMorse) {
                        String[] lettres = item.split(" ");
                        for(String lettre : lettres){
                            sb.append(TranslatorHash.morseToRomain(lettre));
                        }
                        sb.append(" ");
                    }

                    this.richtextboxAllToFr.appendText(sb.toString().trim());
                }
                buff.close();
                this.btTradAllToFr.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.Alert.alertGenerique("Something here to explain");
        }
    }

    public void btExportAllToFrClick(MouseEvent event){
        try {
            if (this.richtextboxAllToFr.getText() != null && !this.richtextboxAllToFr.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle("Choisissez un répertoire ou exporter votre traduction");
                File selectedDirectory = directorychooser.showDialog(Utilitaires.getScene(event));
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textboxExportAllToFr.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextboxAllToFr.getText());
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
                com.method.Alert.alertGenerique("Vérifiez que la traduction a bien eu lieu");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void btNouvelleTradAllToFrClick(MouseEvent event){
        this.textboxAllToFr.clear();
        this.richtextboxAllToFr.clear();
        this.textboxExportAllToFr.clear();
        this.btTradAllToFr.setDisable(false);
        this.btChoixAllToFr.setDisable(false);
    }
}
