/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class ToDoListItem {
    private SimpleStringProperty description;
    private LocalDate date;
    private boolean complete;

    public ToDoListItem(String s1, String s2) {
        //set description to s1
        //set date to s2
        //set complete to false
    }

    public void updateItem(String s1, String s2) {
        //call updateDescription using s1
        //call updateDate using s2
    }

    public void updateDescription(String s1) {
        //set description to s1
    }

    public void updateDate(String s1) {
        //set date to s1
    }

    public void toggleComplete() {
        //if(complete)
            //set complete to false
        //else set complete to true
    }

    public String getDescription() {
        String s = null;
        //set s to description
        return s;
    }

    public String getDate() {
        String s = null;
        //set s to date
        return s;
    }

    public String toString() {
        String string = "";
        //append description and date to string using a particular format
        return string;
    }
}
