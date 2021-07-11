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
        //set description to s1
        updateDescription(s1);
        //set date to s2
        updateDate(s2);
        //set complete to false
        this.complete = false;
    }

    public void updateItem(String s1, String s2) {
        //call updateDescription using s1
        updateDescription(s1);
        //call updateDate using s2
        updateDate(s2);
    }

    public void updateDescription(String s1) {
        //set description to s1
        this.description = new SimpleStringProperty(s1);
    }

    public void updateDate(String s1) {
        //set date to s1
        try {
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            df.setLenient(false);
            df.parse(s1);
            this.date = df.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        String s = this.description.toString();
        //set s to description
        return s;
    }

    public String getDate() {
        String s = this.date;
        //set s to date
        return s;
    }

    public String toString() {
        String string = ("desc=" + getDescription() + " date=" + getDate() + " status=" + complete);
        //append description and date *and complete* to string using a particular format
        return string;
    }
}
