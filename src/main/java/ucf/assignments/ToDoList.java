/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import java.util.*;

public class ToDoList {
    private SimpleStringProperty title;
    public ArrayList<ToDoListItem> list = new ArrayList<>();

    public ToDoList(String name) {
        //set ToDoList title to name
        setTitle(name);
        //set list to empty list
        addItem("2002-01-14", "Description");
    }

    public ToDoList(String name, String date, String desc) {
        setTitle(name);
        addItem(date, desc);
    }

    public String getTitle() {
        //return ToDoList title as string
        return this.title.toString();
    }

    public void setTitle(String s) {
        //set ToDoList title to s
        this.title = new SimpleStringProperty(s);
    }

    public ToDoListItem getItem(int index) {
        return list.get(index);
    }

    public void addItem(String s1, String s2) {
        //add new ToDoListItem object to list using s1 and s2
        this.list.add(new ToDoListItem(s1, s2));
    }

    public void addItem(String s1, String s2, String s3) {
        this.list.add(new ToDoListItem(s1, s2, s3));
    }

    public void removeItem(ToDoListItem li) {
        //remove li from ToDoList
        this.list.remove(li);
    }

    public void editItem(ToDoListItem li, String s1, String s2) {
        //call ToDoListItem.updateItem using li, s1, and s2
        li.updateItem(s1, s2);
    }

    public void sortItemList() {
        //call Collection.sort on list to sort ToDoListItems by date
        Collections.sort(this.list, new SortByDateComparator());
    }

    public String toString() {
        String string = "";
        //Iterate through list collection
        for(ToDoListItem i : list) {
            //append toStrings of ToDoListItems to string
            string += i.toString();
            //append \n after each ToDoListItem
            string += "\n";
        }
        return string;
    }
}
