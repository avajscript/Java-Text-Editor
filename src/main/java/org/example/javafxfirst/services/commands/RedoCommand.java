package org.example.javafxfirst.services.commands;

import javafx.scene.control.TextArea;

public class RedoCommand implements TextFileCommand {
    TextArea textArea;

    public RedoCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public boolean execute() {
        textArea.redo();
        return true;
    }
}
