package org.example.javafxfirst.services.commands;

import javafx.scene.control.IndexRange;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class CutCommand implements TextFileCommand {
    TextArea textArea;

    public CutCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public boolean execute() {
        textArea.cut();

        return false;
    }
}
