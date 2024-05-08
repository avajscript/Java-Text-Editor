package org.example.javafxfirst.services.commands;

import org.example.javafxfirst.services.TextBuffer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadOpenedFileCommand implements TextFileCommand {
    File file;

    public ReadOpenedFileCommand(File file) {
        this.file = file;
    }


    @Override
    public boolean execute() {
        if (file == null) {
            return false;
        }
        try (Scanner myReader = new Scanner(file)) {
            ArrayList<String> fileContents = new ArrayList<>();

            while (myReader.hasNext()) {
                fileContents.add(myReader.nextLine());
            }
            TextBuffer.setContent(fileContents);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

