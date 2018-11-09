package com.method.autre;

import com.main.MainJavaFx;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resource.lang.Lang;
import resource.lang.Translate;
import resource.lang.typetrad.PopUpName;

public class Alert {

    /**
     * Ouvre une popup avec le message passé en paramètre
     * @param libelle : Message à afficher
     * @param lang : langue du message
     */
    public static void alertGenerique(String libelle, Lang lang){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(Translate.haveIt(PopUpName.POP_UP_ERROR, MainJavaFx.getLangue().popUp));
        alert.initStyle(StageStyle.DECORATED);
        alert.setHeaderText(Translate.haveIt(PopUpName.POP_UP_ERROR_NAME, MainJavaFx.getLangue().popUp));
        alert.setContentText(libelle);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resource/Images/icon.png"));
        alert.showAndWait();
    }
}
