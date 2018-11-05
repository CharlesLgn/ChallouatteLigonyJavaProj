package com.util;


import com.controller.NewUIController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import javafx.util.Duration;

import java.text.Normalizer;

public class Utilitaires {
    public static String removeAccents(String s)
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

    public static Window getScene(MouseEvent event){
        Node source = (Node) event.getSource();
        return source.getScene().getWindow();
    }
}
