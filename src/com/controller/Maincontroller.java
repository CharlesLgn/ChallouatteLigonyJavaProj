package com.controller;

import com.main.MainJavaFx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import com.main.MainJavaFx.*;



public class Maincontroller extends Window {

    @FXML
    private Button bt_frtomorse;

    @FXML
    private Button bt_frtoleet;

    @FXML
    private Button bt_alltofrclick;

    public void bt_frtomorseclick(MouseEvent event) {
        load("Français vers Morse", "../gui/FrToMorse.fxml");
    }
     public void bt_frtoleetclick (MouseEvent event){
        load("Français vers L33t", "../gui/FrtoLeet.fxml");
     }

    public void bt_alltofrclick (MouseEvent event){
        load("Langue vers Français", "../gui/AllToFr.fxml");
    }

    private void load(String name, String link){
        try {
            Pane pane = new Pane();
            Scene FrtoLeet = new Scene(pane, 800, 600);
            Stage newWindowfrtoleet = new Stage();
            newWindowfrtoleet.setResizable(false);
            newWindowfrtoleet.setScene(FrtoLeet);
            newWindowfrtoleet.initModality(Modality.WINDOW_MODAL);
            newWindowfrtoleet.initOwner(MainJavaFx.getPrimaryStage());
            newWindowfrtoleet.getIcons().add(new Image("/resource/Images/icon.png"));
            newWindowfrtoleet.setTitle(name);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(link));
            Parent root1 = (Parent) fxmlLoader.load();
            newWindowfrtoleet.setScene(new Scene(root1));
            newWindowfrtoleet.show();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}


