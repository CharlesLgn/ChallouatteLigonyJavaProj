package sample;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import method.JouerSon;
import method.TraductionMorse;

import java.io.*;


public class Controller extends Window {
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

    @FXML
    public void initialize() {

    }

    /**
     * Joue le son morse
     * @param event
     * @throws Exception
     */
     public void btjouersonmorse(MouseEvent event){
         System.out.println("plop");

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
                while ((ligne=buff.readLine())!=null){
                    this.richtextbox_traduction_morse.appendText(TraductionMorse.Tradphrase(ligne));                }
                buff.close();
                this.bt_traduire_morse.setDisable(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
            else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.initStyle(StageStyle.DECORATED);
            alert.setHeaderText("Chemin du fichier");
            alert.setContentText("Sélectionnez un fichier texte valide");
            ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/Images/icon.png"));
            alert.showAndWait();
        }
    }

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
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/Images/icon.png"));
                    alert.showAndWait();
                    //endregion
                } else {
                    //region messagebox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur");
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setHeaderText("Chemin du répertoire");
                    alert.setContentText("Sélectionnez un répertoire valide");
                    ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/Images/icon.png"));
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
                ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/Images/icon.png"));
                alert.showAndWait();
                //endregion
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
}
