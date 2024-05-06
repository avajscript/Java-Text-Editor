package org.example.javafxfirst.services;

import java.io.File;

public class TextFileHolder {
    private static String currentFileName = null;
    private static File currentFile = null;
    private static String LAST_USED_FOLDER = System.getProperty("user.home");

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

    public static String getLastUsedFolder() {
        return LAST_USED_FOLDER;
    }

    public static void setLastUsedFolder(String lastUsedFolder) {
        LAST_USED_FOLDER = lastUsedFolder;
    }

    public static String getCurrentFilePath() {
        return LAST_USED_FOLDER + "\\" + currentFileName;
    }
}
