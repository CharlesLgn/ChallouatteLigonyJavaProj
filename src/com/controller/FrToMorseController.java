package com.controller;

import com.main.MainJavaFx;
import com.method.JouerSon;
import com.method.TranslatorHash;
import com.util.Utilitaires;
import javafx.animation.AnimationTimer;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.ButonName;
import resource.lang.typetrad.PopUpName;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.method.TranslatorListe.romainToMorse;

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
            this.texBoxCheminFrToMorse.setDisable(true);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void btTradFrToMorseClick(MouseEvent event){
        if(this.texBoxCheminFrToMorse.getText() != null && !this.texBoxCheminFrToMorse.getText().isEmpty()) {

            try {
                InputStream flux = new FileInputStream(this.texBoxCheminFrToMorse.getText());
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
                            resmorse = resmorse + TranslatorHash.romainToMorse(""+lettre);
                        }
                    }
                    this.richTextboxFrToMorse.appendText(resmorse.trim());
                }
                buff.close();
                this.btTradFrToMorse.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
        }
    }

    public void btJouerSonFrToMorseClick(MouseEvent event){
        String str;
        str = this.richTextboxFrToMorse.getText();

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
                    com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
                }
            } else {
                com.method.Alert.alertGenerique(Translate.haveIt(PopUpName.POP_UP_ERROR_DESC_EXPORT, MainJavaFx.getLangue().popUp), MainJavaFx.getLangue());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void btNouvelleTradClick(MouseEvent event){
        this.texBoxCheminFrToMorse.clear();
        this.richTextboxFrToMorse.clear();
        this.textboxExporterFrToMorse.clear();
        this.btTradFrToMorse.setDisable(false);
        this.btCheminMorse.setDisable(false);
    }

    private void translate(){
        Lang lang = MainJavaFx.getLangue();

        btCheminMorse.setText(Translate.haveIt(ButonName.CHOOSE_FILE, lang.butonName));
        btTradFrToMorse.setText(Translate.haveIt(ButonName.TRANSLATE, lang.butonName));
        btJouerSonFrToMorse.setText(Translate.haveIt(ButonName.PLAY_TRANSLATE, lang.butonName));
        btExporterFrToMorse.setText(Translate.haveIt(ButonName.EXPORT, lang.butonName));
        btNouvelleTrad.setText(Translate.haveIt(ButonName.NEW_TRANSLATE, lang.butonName));
    }

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
