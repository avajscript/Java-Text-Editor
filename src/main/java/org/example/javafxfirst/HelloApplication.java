package org.example.javafxfirst;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.javafxfirst.constants.AppProperties;
import org.example.javafxfirst.services.TextFileHolder;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("application-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        System.out.println("hello world");
        TextFileHolder.setCurrentFileName("myfile.txt");
        stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}