package org.example.javafxfirst.services.commands;

import org.example.javafxfirst.services.TextBuffer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads file into global TextBuffer, which is used for storing the file text state onto the screen.
 */
public class ReadFileCommand implements TextFileCommand {
    String fileToRead;

    public ReadFileCommand(String fileToRead) {
        this.fileToRead = fileToRead;
    }


    @Override
    public boolean execute() {
        File readFile = new File(fileToRead);
        try (Scanner myReader = new Scanner(readFile)) {
            ArrayList<String> fileContents = new ArrayList<>();
            System.out.println(myReader);
            while (myReader.hasNext()) {
                fileContents.add(myReader.nextLine());
            }
            TextBuffer.setContent(fileContents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
