package org.example.javafxfirst.services.commands;

public class TextFileCommandExecutor {

    public boolean executeOperation(TextFileCommand textFileCommand) {
        return textFileCommand.execute();
    }
}
