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

    public void bt_frtomorseclick(MouseEvent event) {
        try {
            Pane pane = new Pane();
            Scene FrtoMorseScene = new Scene(pane, 800, 600);
            Stage newWindow = new Stage();
            newWindow.setResizable(false);
            newWindow.setScene(FrtoMorseScene);
            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.initOwner(MainJavaFx.getPrimaryStage());
            newWindow.getIcons().add(new Image("/resource/Images/icon.png"));
            newWindow.setTitle("Français vers Morse");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/FrToMorse.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            newWindow.setScene(new Scene(root1));
            newWindow.show();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
     public void bt_frtoleetclick (MouseEvent event){

         try {
             Pane pane = new Pane();
             Scene FrtoMorseScene = new Scene(pane, 800, 600);
             Stage newWindow = new Stage();
             newWindow.setResizable(false);
             newWindow.setScene(FrtoMorseScene);
             newWindow.initModality(Modality.WINDOW_MODAL);
             newWindow.initOwner(MainJavaFx.getPrimaryStage());
             newWindow.getIcons().add(new Image("/resource/Images/icon.png"));
             newWindow.setTitle("Français vers Morse");
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/FrToMorse.fxml"));
             Parent root1 = (Parent) fxmlLoader.load();
             newWindow.setScene(new Scene(root1));
             newWindow.show();

         } catch (Exception ex) {
             System.out.println(ex);
         }

     }



}


