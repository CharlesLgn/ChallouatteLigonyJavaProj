package com.method;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Alert {

    public static javafx.scene.control.Alert alertGenerique(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.initStyle(StageStyle.DECORATED);
        alert.setHeaderText("Chemin du fichier");
        alert.setContentText("Sélectionnez un fichier texte valide");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
        alert.showAndWait();
    }
}
