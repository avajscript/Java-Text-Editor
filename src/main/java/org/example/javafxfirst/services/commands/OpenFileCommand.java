package org.example.javafxfirst.services.commands;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import org.example.javafxfirst.services.TextFileHolder;

import java.io.File;

/**
 * Command design pattern that lets the user select a file and updates global state
 */
public class OpenFileCommand implements TextFileCommand {

    private Scene scene;

    public OpenFileCommand(Scene scene) {
        this.scene = scene;
    }

    /**
     * Open file dialog, user selects file, updates the current file and loads it
     */
    @Override
    public void execute() {

        FileChooser fileChooser = new FileChooser();

        // set file extensions to only text files
        FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(fileExtensions);

        fileChooser.setTitle("Open Text File");
        // load file chooser from last directory
        fileChooser.setInitialDirectory(new File(TextFileHolder.getLastUsedFolder()));
        File file = fileChooser.showOpenDialog(scene.getWindow());

        // load file into buffer

        if (file != null) {
            TextFileHolder.setCurrentFile(file);
            // set file chooser to directory where file is in
            TextFileHolder.setLastUsedFolder(file.getParent());

            // Write the file to text buffer (stores array of text of the file)
        }
    }

}
