package org.example.javafxfirst.services.commands;

import org.example.javafxfirst.services.TextBuffer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SaveCommand implements TextFileCommand {
    String fileToWriteTo;

    public SaveCommand(String fileToWriteTo) {
        this.fileToWriteTo = fileToWriteTo;
    }

    @Override
    public boolean execute() {
        boolean fileState = true;
        try (Writer fileWriter = new FileWriter(fileToWriteTo);) {
            // clear the file
            fileWriter.write("");
            // write all text content into the file line by line or by array line
            for (String text : TextBuffer.getContent()) {
                fileWriter.append(text + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileState;

    }
}
