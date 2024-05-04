package org.example.javafxfirst.scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ApplicationMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("application-view.fxml"));
        System.out.println(fxmlLoader.getLocation());
//       Scene scene = new Scene(fxmlLoader.load());
//
//        stage.setTitle("Text Editor");
//        stage.setScene(scene);
//        stage.show();
    }


     public static void main(String[] args) {
        launch();
     }
}
