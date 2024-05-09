package org.example.javafxfirst.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.javafxfirst.HelloApplication;
import org.example.javafxfirst.constants.AppProperties;
import org.example.javafxfirst.constants.Constants;
import org.example.javafxfirst.services.TextBuffer;
import org.example.javafxfirst.services.TextFileHolder;
import org.example.javafxfirst.services.WindowUpdater;
import org.example.javafxfirst.services.commands.*;
import org.example.javafxfirst.services.state.KeyCommander;
import org.example.javafxfirst.services.state.KeyCommanderState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainController {
    TextFileCommandExecutor textFileCommandExecutor = new TextFileCommandExecutor();
    Stage stage = HelloApplication.getStage();
    WindowUpdater windowUpdater = new WindowUpdater(stage);
    AppProperties appProperties = new AppProperties();

    KeyCommanderState keyCommanderState;

    @FXML
    protected TextFlow textContent;

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
        //keyCommanderState = new KeyCommanderState(textContent);
        //addKeyListener();
    }

    /**
     * Listens to key events to run commands like copy/paste, etc
     */
    public void addKeyListener() {
        textContent.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();
                switch (keyCode) {
                    case CONTROL:
                        keyCommanderState.getCtrlKeyCommander().pressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getCtrlKeyCommander());
                        break;
                    case ALT:
                        keyCommanderState.getAltKeyCommander().pressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getAltKeyCommander());
                        break;
                    case SHIFT:
                        keyCommanderState.getShiftKeyCommander().pressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getShiftKeyCommander());
                        break;
                    case TAB:
                        keyCommanderState.getTabKeyCommander().pressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getTabKeyCommander());
                        break;
                    default:
                        break;
                }

                KeyCommander activeKeyState = keyCommanderState.getActiveKeyState();
                if (activeKeyState != null) {
                    if (activeKeyState.isKeyPressed()) {
                        activeKeyState.pressSecondKey(keyCode, textFileCommandExecutor);
                    }
                }
            }
        });

        textContent.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();
                KeyCommander activeKeyState = keyCommanderState.getActiveKeyState();
                switch (keyCode) {
                    case CONTROL:
                        keyCommanderState.getCtrlKeyCommander().unPressKey();
                        if (activeKeyState == keyCommanderState.getCtrlKeyCommander()) {
                            keyCommanderState.setActiveKeyState(null);
                        }
                        break;
                    case ALT:
                        keyCommanderState.getAltKeyCommander().unPressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getAltKeyCommander());
                        if (activeKeyState == keyCommanderState.getAltKeyCommander()) {
                            keyCommanderState.setActiveKeyState(null);
                        }
                        break;
                    case SHIFT:
                        keyCommanderState.getShiftKeyCommander().unPressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getShiftKeyCommander());
                        if (activeKeyState == keyCommanderState.getShiftKeyCommander()) {
                            keyCommanderState.setActiveKeyState(null);
                        }
                        break;
                    case TAB:
                        keyCommanderState.getTabKeyCommander().unPressKey();
                        keyCommanderState.setActiveKeyState(keyCommanderState.getTabKeyCommander());
                        if (activeKeyState == keyCommanderState.getTabKeyCommander()) {
                            keyCommanderState.setActiveKeyState(null);
                        }
                        break;
                    default:
                        break;
                }
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
            //commandState = textFileCommandExecutor.executeOperation(new LoadFileOntoScreenCommand(textContent));
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
        //TextBuffer.setContent(new ArrayList<>(Arrays.asList(textContent.getText().split("\n"))));
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
        //textContent.undo();
    }

    @FXML
    protected void onRedoMenuItemClicked() {
        //textContent.redo();
    }

    @FXML
    protected void onCutMenuItemClicked() {
        //textFileCommandExecutor.executeOperation(new CutCommand(textContent));
    }

    @FXML
    protected void onCopyMenuItemClicked() {
        //textFileCommandExecutor.executeOperation(new CopyCommand(textContent));
    }

    @FXML
    protected void onPasteMenuItemClicked() {

    }

    @FXML
    protected void onDeleteMenuItemClicked() {

    }

    @FXML
    protected void onFindMenuItemClicked() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dialogs/Find.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Find Text");
        stage.show();
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
