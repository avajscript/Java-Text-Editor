package org.example.javafxfirst.services.state;

import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import org.example.javafxfirst.services.commands.TextFileCommand;
import org.example.javafxfirst.services.commands.TextFileCommandExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class KeyCommander {
    /**
     * Whether this key is currently click, which is represented by keyPressed
     */
    boolean keyPressed = false;
    /**
     * The keycode (CTRL, ALT, SHIFT), etc for this class. Indicates the primary key for double key click functions
     */
    KeyCode keyCode;
    /**
     * Stores key codes (C, V, X), etc with their corresponding function (copy, paste, cut), etc.
     */
    Map<KeyCode, TextFileCommand> commandMap = new HashMap<>();

    /**
     * Instantiate the object
     *
     * @param keyCode the keyCode that represents this object
     */
    public KeyCommander(KeyCode keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * When the corresponding keyCode is clicked
     */
    public void pressKey() {
        this.keyPressed = true;
    }

    /**
     * When the corresponding keyCode is unclicked
     */
    public void unPressKey() {
        this.keyPressed = false;
    }

    /**
     * Check to see if this key, represented by keyCode is currently clicked
     *
     * @return true if currently clicked, false otherwrise
     */
    public boolean isKeyPressed() {
        return this.keyPressed;
    }

    /**
     * @param keyCode         the second key to be pressed to run the TextFileCommand function
     * @param textFileCommand a function to be run when the keyCode key is clicked
     * @return
     */
    public boolean addCommand(KeyCode keyCode, TextFileCommand textFileCommand) {
        boolean keyExists = true;
        System.out.println(commandMap.get(keyCode));
        if (commandMap.get(keyCode) == null) {
            commandMap.put(keyCode, textFileCommand);
            keyExists = false;
        }
        return keyExists;
    }

    // runs the designated function when the client clicks two keys at once, Ex. Ctrl+C
    public void pressSecondKey(KeyCode keyCode, TextFileCommandExecutor textFileCommandExecutor) {
        TextFileCommand textFileCommand = commandMap.get(keyCode);

        if (textFileCommand != null) {
            textFileCommandExecutor.executeOperation(textFileCommand);

        }
    }

}
