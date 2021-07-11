/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NewItemPopupController {
    @FXML public static TextField dateField;
    @FXML public static TextArea descriptionField;

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        //clear fields
        dateField.clear();
        descriptionField.clear();
        //close stage
        Stage stage = (Stage) dateField.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmButtonPressed(ActionEvent event) {
        Stage stage = (Stage) dateField.getScene().getWindow();
        stage.close();
    }
}
