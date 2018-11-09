package com.method.autre;


import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

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
