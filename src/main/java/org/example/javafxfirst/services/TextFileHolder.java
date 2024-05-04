package org.example.javafxfirst.services;

import java.io.File;

public class TextFileHolder {
    private static String currentFileName;
    private static File currentFile;

    public static String getCurrentFileName() {
        return currentFileName;
    }

    public static void setCurrentFileName(String newCurrentFileName) {
        currentFileName = newCurrentFileName;
    }

    public static File getCurrentFile() {
        return currentFile;
    }

    /**
     * Updates the current file and file name attributes
     *
     * @param newCurrentFile
     */
    public static void setCurrentFile(File newCurrentFile) {
        currentFileName = newCurrentFile.getName();
        currentFile = newCurrentFile;
    }
}
