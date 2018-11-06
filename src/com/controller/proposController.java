package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class proposController implements Initializable {
    @FXML
    private GridPane gridpane;

    private static Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setStage((Stage) gridpane.getScene().getWindow());
        //System.out.println(stage.getTitle());

       /* stage.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean onHidden, Boolean onShown) {
                //code
                if (onShown) {
                    stage.close();
                }
            }
        });*/
    }

    private void setStage(Stage st){
        this.stage = st;
    }
}

