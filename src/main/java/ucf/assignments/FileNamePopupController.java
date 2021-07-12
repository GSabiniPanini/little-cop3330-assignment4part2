/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FileNamePopupController {
    @FXML public static TextField fileNameField;

    @FXML
    void confirmButtonPressed(ActionEvent event) {
        Stage stage = (Stage) fileNameField.getScene().getWindow();
        stage.close();
    }
}
