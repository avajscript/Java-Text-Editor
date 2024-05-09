package org.example.javafxfirst.services.commands;

import javafx.scene.control.TextArea;

public class UndoCommand implements TextFileCommand {
    TextArea textArea;

    public UndoCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public boolean execute() {
        textArea.undo();
        return true;
    }
}
