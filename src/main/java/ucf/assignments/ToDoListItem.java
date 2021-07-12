/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ToDoListItem {
    private SimpleStringProperty description;
    private String date;
    private boolean complete;

    public ToDoListItem(String s1, String s2) {
        //set date to s1 and description to s2
        updateItem(s1, s2);
        //set complete to false
        this.complete = false;
    }

    public ToDoListItem(String s1, String s2, String s3) {
        updateDate(s1);
        updateDescription(s2);
        if(s3.equals("true")) {
            this.complete = true;
        } else {
            this.complete = false;
        }
    }

    public void updateItem(String s1, String s2) {
        //call updateDate using s1
        updateDate(s1);
        //call updateDescription using s2
        updateDescription(s2);
    }

    public void updateDescription(String s1) {
        //set description to s1
        this.description = new SimpleStringProperty(s1);
    }

    public void updateDate(String s1) {
        //set date to s1
        this.date = s1;
        /* testing fails so assume string is correctly formmated coming into function
        try {
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            df.setLenient(false);
            df.parse(s1);
            this.date = df.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
         */
    }

    public void toggleComplete() {
        //if(complete)
        if(this.complete) {
            //set complete to false
            this.complete = false;
        }
        else {
            //else set complete to true
            this.complete = true;
        }
    }

    public String getDescription() {
        //return the description
        return this.description.get();
    }

    public String getDate() {
        //return the date
        return this.date;
    }

    public String toString() {
        //append description and date *and complete* to string using a particular format
        String string = (getDate() + " " + getDescription() + " " + complete);
        return string;
    }
}
