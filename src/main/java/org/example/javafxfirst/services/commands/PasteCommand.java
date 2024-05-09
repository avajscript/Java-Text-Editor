package org.example.javafxfirst.services.commands;

import javafx.scene.control.TextArea;

public class PasteCommand implements TextFileCommand {
    private TextArea textArea;

    public PasteCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public boolean execute() {
        textArea.paste();
        return true;
    }
}
