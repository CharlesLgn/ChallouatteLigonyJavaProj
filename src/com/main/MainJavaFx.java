package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainJavaFx extends Application {

    private static Stage prStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage);
        prStage = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("../gui/sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../gui/main.fxml"));
        prStage.setTitle("Traducteur");
        prStage.setScene(new Scene(root, 800, 600));
        prStage.setResizable(false);
        prStage.getIcons().add(new Image("/resource/Images/icon.png"));
        prStage.show();
    }

    public static Stage getPrimaryStage() {
        return prStage;
    }

    private void setPrimaryStage(Stage pStage) {
        MainJavaFx.prStage = prStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
