package org.example.javafxfirst.services;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.example.javafxfirst.services.commands.ReadFileCommand;
import org.example.javafxfirst.services.commands.TextFileCommand;

import java.nio.file.Paths;

public class WindowUpdater {
    Stage stage;

    public WindowUpdater(Stage stage) {
        this.stage = stage;
    }

    public void updateTitle(String title) {
        stage.setTitle(title);
    }

    public void deleteRecentMenuItems(Menu menu) {
        menu.getItems().clear();
    }

    public void renderRecentMenu(Menu menu, String[] filePaths) {
        for (String filePath : filePaths) {
            // get the file name from file path. Eg. myfile.txt
            String fileName = Paths.get(filePath).getFileName().toString();

            MenuItem menuItem = new MenuItem(fileName);
            // read the file into the screen when the menu item is clicked
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    new ReadFileCommand(filePath).execute();
                }
            });

            menu.getItems().add(menuItem);
        }

    }
}
