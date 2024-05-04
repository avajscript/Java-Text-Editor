package org.example.javafxfirst.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import org.example.javafxfirst.globals.FileGlobals;
import org.example.javafxfirst.services.TextBuffer;
import org.example.javafxfirst.services.TextFileHolder;
import org.example.javafxfirst.services.commands.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainController {
    TextFileCommandExecutor textFileCommandExecutor = new TextFileCommandExecutor();

    // menu items
    @FXML
    protected MenuItem save;

    @FXML
    protected MenuItem load;

    @FXML
    protected TextArea textContent;

    // icons
    @FXML
    protected Button saveIcon;

    @FXML
    protected Button loadIcon;

    @FXML
    protected Button printIcon;


    @FXML
    protected Button undoIcon;

    @FXML
    protected Button redoIcon;

    @FXML
    protected Button searchicon;


    // Menu items

    /**
     * Used to save a file
     */
    @FXML
    protected void onSaveMenuItemClicked() {
        // Update TextBuffer content to array list of textArea
        TextBuffer.setContent(new ArrayList<>(Arrays.asList(textContent.getText().split("\n"))));
        // Save current text to current file
        textFileCommandExecutor.executeOperation(new SaveCommand(TextFileHolder.getCurrentFileName()));
    }

    @FXML
    protected void onOpenMenuItemClicked() {
        textFileCommandExecutor.executeOperation(new ReadFileCommand(TextFileHolder.getCurrentFileName()));
    }

    // icons
    @FXML
    protected void onSaveIconClicked() {
        onSaveMenuItemClicked();
    }

    @FXML
    protected void onLoadIconClicked() {
        textFileCommandExecutor.executeOperation(new OpenFileCommand(loadIcon.getScene()));
        textFileCommandExecutor.executeOperation(new ReadOpenedFileCommand(TextFileHolder.getCurrentFile()));
        textFileCommandExecutor.executeOperation(new LoadFileOntoScreenCommand(textContent));
        System.out.println("Hello world");
        System.out.println(FileGlobals.LAST_USED_FOLDER);
    }

    @FXML
    protected void onPrintIconClicked() {

    }

    @FXML
    protected void onUndoIconClicked() {

    }

    @FXML
    protected void onRedoIconClicked() {

    }

    @FXML
    protected void onSearchIconClicked() {

    }

}
