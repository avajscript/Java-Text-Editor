package org.example.javafxfirst.services.state;

import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.example.javafxfirst.services.commands.CopyCommand;
import org.example.javafxfirst.services.commands.CutCommand;
import org.example.javafxfirst.services.commands.PasteCommand;
import org.example.javafxfirst.services.commands.TextFileCommand;

public class KeyCommanderState {
    KeyCommander activeKeyState;
    KeyCommander ctrlKeyCommander;
    KeyCommander altKeyCommander;
    KeyCommander shiftKeyCommander;
    KeyCommander tabKeyCommander;

    public KeyCommanderState(TextArea textArea) {
        buildCtrlCommander(textArea);
        buildAltKeyCommander(textArea);
        buildShiftKeyCommander(textArea);
        buildTabKeyCommander(textArea);
    }

    private void buildCtrlCommander(TextArea textArea) {
        ctrlKeyCommander = new KeyCommander(KeyCode.CONTROL);
//        // ctrl-c copy command
//        ctrlKeyCommander.addCommand(KeyCode.C, new CopyCommand(textArea));
//        // ctrl-X cut command
//        ctrlKeyCommander.addCommand(KeyCode.X, new CutCommand(textArea));
//        // ctrl-v paste command
//        ctrlKeyCommander.addCommand(KeyCode.V, new PasteCommand(textArea));
//        // ctrl-z undo command
//        ctrlKeyCommander.addCommand(KeyCode.Z, new PasteCommand(textArea));


    }

    private void buildAltKeyCommander(TextArea textArea) {
        altKeyCommander = new KeyCommander(KeyCode.COMMAND);

    }

    private void buildShiftKeyCommander(TextArea textArea) {
        shiftKeyCommander = new KeyCommander(KeyCode.SHIFT);

    }

    private void buildTabKeyCommander(TextArea textArea) {
        tabKeyCommander = new KeyCommander(KeyCode.TAB);

    }

    public KeyCommander getCtrlKeyCommander() {
        return ctrlKeyCommander;
    }

    public KeyCommander getAltKeyCommander() {
        return altKeyCommander;
    }

    public KeyCommander getShiftKeyCommander() {
        return shiftKeyCommander;
    }

    public KeyCommander getTabKeyCommander() {
        return tabKeyCommander;
    }


    public void setActiveKeyState(KeyCommander activeKeyState) {
        this.activeKeyState = activeKeyState;
    }

    public KeyCommander getActiveKeyState() {
        return activeKeyState;
    }
}
