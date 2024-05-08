package org.example.javafxfirst.services.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileCommandTest {
    @Test
    public void testExecute() {
        TextFileCommandExecutor textFileCommandExecutor = new TextFileCommandExecutor();
        boolean commandState = textFileCommandExecutor.executeOperation(new ReadFileCommand("C:\\Users\\matth\\Documents\\homework_sem3\\networking\\ipv4_subnetting\\JavaFXFirst\\app.properties"));
        assertTrue(commandState, "Command should return true meaning the file was not opened properly. This means the file does not exist or the function is broken.");
    }

}