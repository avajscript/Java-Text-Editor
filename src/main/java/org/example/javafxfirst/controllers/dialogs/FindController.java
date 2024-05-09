package org.example.javafxfirst.controllers.dialogs;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FindController {
    @FXML
    TextField findTextField;

    @FXML
    Button caseButton;

    @FXML
    FontAwesomeIconView upArrow;

    @FXML
    FontAwesomeIconView downArrow;

    @FXML
    public void initialize() {
        System.out.println(findTextField.getText());
        findTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //findTextField.get
        });
    }

}
