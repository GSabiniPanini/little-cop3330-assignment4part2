/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.beans.property.Property;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/* not necessary i think
enum Filter {
    SHOWALL,
    SHOWNOTDONE,
    SHOWDONE
}
*/

public class ToDoListModel {
    private ArrayList<ToDoList> toDoListGroup;
    /*
    public RadioButton selectedButton;
    fix initialize in constructor if i put this back in
     */

    public ToDoListModel() {
        //set filter to selectedToggleGroup NOT NEEDED
        //this.selectedButton = (RadioButton) filterToggleGroup.getSelectedToggle();
        //initialize toDoListGroup
        this.toDoListGroup = new ArrayList<ToDoList>();
        this.toDoListGroup.add(new ToDoList("name"));
    }

    /*
    removed in second part
    public void addList() {
        //bring up popup window with string input box
        //call appendList with string
        //call updateViews
    }
    private void appendList(String s) {
        //add ToDoList object with title s to toDoListGroup
        this.toDoListGroup.add(new ToDoList(s));
    }
    public void removeList() {
        //check to see if a ToDoList is selected
            //bring up alert confirmation dialog
            //call removeObjectFromList with selected ToDoList
            //call updateViews
        //if not do nothing
    }
    public void renameList() {
        //check to see if a ToDoList is selected
            //bring up popup window with string input box
            //call changeListName with selected ToDoList and returned string
            //call updateViews
        //if not do nothing
    }
    private void updateList(Collection<ToDoList> c) {
        //set listTreeTable to c
    }
    */

    private void removeObjectFromList(ToDoList l) {
        //remove ToDoList object l from toDoListGroup
        this.toDoListGroup.remove(l);
    }

    private void changeListName(ToDoList l, String s) {
        //call ToDoList.setTitle using l and s
        l.setTitle(s);
    }

    public void addItem() {
        //NOW NULL, ONLY ONE LIST ANYWAY check to see if a ToDoList is selected
        //bring up popup window with two string input boxes for desc and date
        try {
            Parent newItemRoot = FXMLLoader.load(getClass().getResource("NewItemPopup.fxml"));
            Scene newItemPopup = new Scene(newItemRoot);
            Stage popup = null;
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setScene(newItemPopup);
            popup.setTitle("New Task");
            popup.showAndWait();

            //call addItemToList with selected ToDoList and the two returned strings
            addItemToList(toDoListGroup.get(0), NewItemPopupController.dateField.getText(), NewItemPopupController.descriptionField.getText());
            //call updateViews
            updateViews();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addItemToList(ToDoList l, String s1, String s2) {
        //call ToDoList.addItem using l, s1, and s2
        l.addItem(s1, s2);
    }

    public void removeItem() {
        //check to see if a ToDoListItem is selected
            //call removeItemFromList with selected ToDoList and ToDoListItem
            //call updateViews
        //if not do nothing
    }

    private void removeItemFromList(ToDoList l, ToDoListItem li) {
        //call ToDoList.removeItem using l and li
        l.removeItem(li);
    }

    public void editItem() {
        //check to see if a ToDoListItem is selected
            //bring up edit popup window that displays ToDoListItem variables in editable fields loaded with existing data
            //call editItemValues using selected ToDoList and ToDoListItem, use two strings from edit window as params
            //call updateViews
        //if not do nothing
    }

    private void editItemValues(ToDoList l, ToDoListItem li, String s1, String s2) {
        //call ToDoList.editItem using l, li, s1, and s2
        l.editItem(li, s1, s2);
    }

    public void completeToggle() {
        //check to see if a ToDoListItem is selected
            //call completeTogglePass using selected ToDoList and ToDoListItem
            //call updateViews
        //if not do nothing
    }

    private void completeTogglePass(ToDoListItem li) {
        //call ToDoList.ToDoListItem.toggleComplete using li
        li.toggleComplete();
    }

    public void sort() {
        //call sortItemList with the selected ToDoList
        toDoListGroup.get(0).sortItemList();
        //call updateViews
        updateViews();
    }

    public void updateViews() {
        //call updateFilter
        updateFilter();
        //call updateTable with selected ToDoList
        updateTable(toDoListGroup.get(0));
        //REMOVED call updateList with current Collection<ToDoList>
    }

    public void updateFilter() {
        //change the filter variable to match the selected filter
        //call changeFilter with selectedToggleGroup Property
    }

    private void changeFilter(Property p) {
        //switch(p)
            //showall: set filter to SHOWALL
            //shownotdone: set filter to SHOWNOTDONE
            //showdone: set filter to SHOWDONE
    }

    private void updateTable(ToDoList l) {
        //set toDoListView to l
    }

    public void save() {
        //bring up popup to ask for which ToDoList to save
        //ask for String to name the file
        //overwrite or create file
        //print selected ToDoList's toString to file
        //close file
    }

    public void saveAll() {
        //bring up popup to ask for file name
        //overwrite or create file
        //call getBigString to get compiled string
        //print string to file
        //close file
    }

    private String getBigString() {
        String string = "";
        //iterate through toDoListGroup
            //append ToDoList toStrings to string
            //append \n after each ToDoList
        return string;
    }

    public void load() {
        //bring up popup to ask for a filename
        //search for file
        //if found
            //call parseFile using file to get a ToDoList
            //close file
            //call addList to add ToDoList object to toDoListGroup
        //else do nothing
    }

    private ToDoList parseFile(File file) {
        ToDoList obj = null;
        //have a parsing method here to create a ToDoList object out of the line of text in the file
        //store the ToDoList in obj
        return obj;
    }

    public void loadCollection() {
        //bring up popup to ask for a filename
        //search for file
        //if found
            //call parseFileCollection using file to get a parsed collection
            //close file
            //call addCollection using parsedCollection and toDoListGroup to add parsed Collection to toDoListGroup
        //else do nothing
    }

    //redo to replace current collection
    public ArrayList<ToDoList> addCollection(ArrayList<ToDoList> c1, ArrayList<ToDoList> c2) {
        ArrayList<ToDoList> temp = null;
        //set temp to c1.add(c2)
        return temp;
    }
    
    private Collection<ToDoList> parseFileCollection(File file) {
        Collection<ToDoList> temp = null;
        //have a parsing method here to create ToDoList objects with every line of file
        //store each object into temp collection
        return temp;
    }
    
}
