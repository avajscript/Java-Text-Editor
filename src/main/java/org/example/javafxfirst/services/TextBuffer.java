package org.example.javafxfirst.services;

import java.util.ArrayList;

public class TextBuffer {
    private static ArrayList<String> content = null;

    public static ArrayList<String> getContent() {
        return content;
    }

    public static void setContent(ArrayList<String> newContent) {
        content = newContent;
    }
}
