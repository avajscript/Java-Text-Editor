package org.example.javafxfirst.services.commands;

import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class CopyCommand implements TextFileCommand {
    TextArea textArea;

    public CopyCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public boolean execute() {
        textArea.copy();
        return true;
    }
}
