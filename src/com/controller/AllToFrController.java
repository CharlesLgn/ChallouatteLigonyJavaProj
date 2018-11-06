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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllToFrController implements Initializable {

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

    /**
     * Ouvre une fenêtre de choix de fichier texte pour y récupérer son contenu
     * @param event : Évènement click de souris
     */
    public void btChoixAllToFrClick(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(Translate.haveIt(PopUpName.CHOOSE_FILE_TRAD, MainJavaFx.getLangue().popUp));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters();
        try {
            File file = fileChooser.showOpenDialog(Utilitaires.getScene(event));
            if (file != null) {
                this.textboxAllToFr.setText(file.getAbsolutePath());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * Traduit le texte contenu dans le fichier et affiche le résultat dans la TextArea
     * @param event : Évènement click souris
     */
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
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_TRAD, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
        }
    }

    /**
     * Vide le formulaire
     * @param event : Évènement souris
     */
    public void btNouvelleTradAllToFrClick(MouseEvent event){
        this.textboxAllToFr.clear();
        this.richtextboxAllToFr.clear();
        this.textboxExportAllToFr.clear();
    }

    /**
     * Permet d'exporter la traduction vers un fichier texte
     * @param event : Évènement clic souris
     */
    public void btExportAllToFrClick(MouseEvent event){
        try {
            if (this.richtextboxAllToFr.getText() != null && !this.richtextboxAllToFr.getText().isEmpty()) {
                DirectoryChooser directorychooser = new DirectoryChooser();
                directorychooser.setTitle(Translate.haveIt(PopUpName.CHOOSE_FILE_EXPORT, MainJavaFx.getLangue().popUp));
                File selectedDirectory = directorychooser.showDialog(Utilitaires.getScene(event));
                if (selectedDirectory != null) {
                    File fichierexport = new File(selectedDirectory + "\\" + this.textboxExportAllToFr.getText() + ".txt");
                    fichierexport.createNewFile();
                    FileWriter fichierexportwrite =new FileWriter(fichierexport);
                    fichierexportwrite.write(this.richtextboxAllToFr.getText());
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
     * Réalise la traduction des composants
     */
    private void translate(){
        Lang lang = MainJavaFx.getLangue();

        btChoixAllToFr.setText(Translate.haveIt(ButonName.CHOOSE_FILE, lang.butonName));
        btTradAllToFr.setText(Translate.haveIt(ButonName.TRANSLATE, lang.butonName));
        btExportAllToFr.setText(Translate.haveIt(ButonName.EXPORT, lang.butonName));
        btNouvelleTradAllToFr.setText(Translate.haveIt(ButonName.NEW_TRANSLATE, lang.butonName));
    }

    /**
     * Initialisation de la fenêtre, lance la traduction
     * @param location not used
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
