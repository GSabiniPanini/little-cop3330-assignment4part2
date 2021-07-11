/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.util.Collection;

public class ToDoList {
    private SimpleStringProperty title;
    private Collection<ToDoListItem> list;

    public ToDoList(String name) {
        //set ToDoList title to name
        //set list to empty list
    }

    public String getTitle() {
        //return ToDoList title as string
        return "";
    }

    public void setTitle(String s) {
        //set ToDoList title to s
    }

    public void addItem(String s1, String s2) {
        //add new ToDoListItem object to list using s1 and s2
    }

    public void removeItem(ToDoListItem li) {
        //remove li from ToDoList
    }

    public void editItem(ToDoListItem li, String s1, String s2) {
        //call ToDoListItem.updateItem using li, s1, and s2
    }

    public void sortItemList() {
        //call Collection.sort on list to sort ToDoListItems by date
    }

    public String toString() {
        String string = "";
        //Iterate through list collection
            //append toStrings of ToDoListItems to string
            //append \n after each ToDoListItem
        return string;
    }

}
