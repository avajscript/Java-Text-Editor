package org.example.javafxfirst.services.commands;

import javafx.scene.control.TextArea;
import org.example.javafxfirst.services.TextBuffer;

/**
 * Puts the most recently opened file onto the screen
 */
public class LoadFileOntoScreenCommand implements TextFileCommand {
    private TextArea textContent;

    public LoadFileOntoScreenCommand(TextArea textContent) {
        this.textContent = textContent;
    }


    /**
     * Sets the text area on the screen to the loaded file contents
     */
    @Override
    public void execute() {
        if (TextBuffer.getContent() != null) {
            textContent.setText(String.join("\n", TextBuffer.getContent()));
        }

    }
}
