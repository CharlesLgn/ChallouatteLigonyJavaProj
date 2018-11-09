package com.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreen {
    public void SplashScreen() {
        try {
            Stage st = new Stage();
            st.initModality(Modality.NONE);
            //st.initOwner(pnPrincipal.getScene().getWindow());
            st.initStyle(StageStyle.TRANSPARENT);

            Parent root = FXMLLoader.load(getClass().getResource("/gui/SplashScreen.fxml"));
            Scene scene = new Scene(root, 500, 300);
            st.setScene(scene);
            st.setResizable(false);
            st.show();

            Thread.sleep(4000);
            st.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
