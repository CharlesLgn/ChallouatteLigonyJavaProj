package com.method;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Alert {

    public static void alertGenerique(String libelle){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.initStyle(StageStyle.DECORATED);
        alert.setHeaderText("Chemin du fichier");
        alert.setContentText(libelle);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
        alert.showAndWait();
    }
}
