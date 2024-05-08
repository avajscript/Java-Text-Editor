package org.example.javafxfirst.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.example.javafxfirst.HelloApplication;
import org.example.javafxfirst.constants.AppProperties;
import org.example.javafxfirst.constants.Constants;
import org.example.javafxfirst.services.TextBuffer;
import org.example.javafxfirst.services.TextFileHolder;
import org.example.javafxfirst.services.WindowUpdater;
import org.example.javafxfirst.services.commands.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainController {
    TextFileCommandExecutor textFileCommandExecutor = new TextFileCommandExecutor();
    Stage stage = HelloApplication.getStage();
    WindowUpdater windowUpdater = new WindowUpdater(stage);
    AppProperties appProperties = new AppProperties();

    @FXML
    protected TextArea textContent;

    // menu items
    @FXML
    protected MenuItem newMenuItem;

    @FXML
    protected MenuItem openMenuItem;
    @FXML
    protected Menu openRecentMenu;
    @FXML
    protected MenuItem saveMenuitem;
    @FXML
    protected MenuItem saveAsMenuItem;
    @FXML
    protected MenuItem quitMenuItem;
    @FXML
    protected MenuItem undoMenuItem;
    @FXML
    protected MenuItem redoMenuItem;
    @FXML
    protected MenuItem cutMenuItem;
    @FXML
    protected MenuItem copyMenuItem;
    @FXML
    protected MenuItem pasteMenuItem;
    @FXML
    protected MenuItem deleteMenuItem;
    @FXML
    protected MenuItem findMenuItem;

    @FXML
    protected MenuItem findAndReplaceMenuItem;

    @FXML
    protected Menu colorThemesMenu;

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

    // runs when the Controller is initialized
    @FXML
    private void initialize() {
        appProperties.checkFileExistsAndCreate();
        windowUpdater.renderRecentMenu(openRecentMenu, appProperties.getPropertyAsArray("recentFiles"));
        addKeyListener();
    }

    /**
     * Listens to key events to run commands like copy/paste, etc
     */
    public void addKeyListener() {
        textContent.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("key event?");
                System.out.println(keyEvent.getCode());
            }
        });

        textContent.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }

    // Menu item click listeners

    @FXML
    protected void onNewMenuItemClicked() {

    }

    @FXML
    protected void onOpenMenuItemClicked() {
        // open file using FileChooser
        boolean commandState = textFileCommandExecutor.executeOperation(new OpenFileCommand(loadIcon.getScene()));
        // parse file contents into buffer
        if (commandState) {
            commandState = textFileCommandExecutor.executeOperation(new ReadOpenedFileCommand(TextFileHolder.getCurrentFile()));
        }
        if (commandState) {
            // render buffer onto screen
            commandState = textFileCommandExecutor.executeOperation(new LoadFileOntoScreenCommand(textContent));
        }
        if (commandState) {
            // update window title with file name
            windowUpdater.updateTitle(TextFileHolder.getCurrentFileName() + "    (" + TextFileHolder.getCurrentFilePath() + ")");
            // add the file path to the properties
            appProperties.updatePropertyArray("recentFiles", TextFileHolder.getCurrentFileName(), Constants.PROPERTY_RECENT_FILES_LENGTH);
            windowUpdater.deleteRecentMenuItems(openRecentMenu);
            windowUpdater.renderRecentMenu(openRecentMenu, appProperties.getPropertyAsArray("recentFiles"));

        }

    }

    @FXML
    protected void onOpenRecentMenuItemClicked() {

    }

    /**
     * Used to save a file
     */
    @FXML
    protected void onSaveMenuItemClicked() {
        // Update TextBuffer content to array list of textArea
        TextBuffer.setContent(new ArrayList<>(Arrays.asList(textContent.getText().split("\n"))));
        // Save current text to current file
        textFileCommandExecutor.executeOperation(new SaveCommand(TextFileHolder.getCurrentFilePath()));
    }


    @FXML
    protected void onSaveAsMenuItemClicked() {

    }

    @FXML
    protected void onQuitMenuItemClicked() {

    }

    @FXML
    protected void onUndoMenuItemClicked() {
        textContent.undo();
    }

    @FXML
    protected void onRedoMenuItemClicked() {
        textContent.redo();
    }

    @FXML
    protected void onCutMenuItemClicked() {
        textFileCommandExecutor.executeOperation(new CutCommand(textContent));
    }

    @FXML
    protected void onCopyMenuItemClicked() {
        textFileCommandExecutor.executeOperation(new CopyCommand(textContent));
    }

    @FXML
    protected void onPasteMenuItemClicked() {

    }

    @FXML
    protected void onDeleteMenuItemClicked() {

    }

    @FXML
    protected void onFindMenuItemClicked() {

    }

    @FXML
    protected void onFindAndReplaceMenuItemClicked() {

    }


    // icons
    @FXML
    protected void onSaveIconClicked() {
        onSaveMenuItemClicked();
    }

    @FXML
    protected void onLoadIconClicked() {
        onOpenMenuItemClicked();
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
