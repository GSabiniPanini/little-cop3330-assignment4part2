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
enum Filter { }
*/

public class ToDoListModel {
    public ArrayList<ToDoList> toDoListGroup;
    private String filter;
    /*REMOVED
    public RadioButton selectedButton;
    fix initialize in constructor if i put this back in*/

    public ToDoListModel() {
        //REMOVED this.selectedButton = (RadioButton) filterToggleGroup.getSelectedToggle();
        //initialize toDoListGroup
        this.toDoListGroup = new ArrayList<ToDoList>();
        this.toDoListGroup.add(new ToDoList("name"));
    }


    private void removeObjectFromList(ToDoList l) {
        //remove ToDoList object l from toDoListGroup
        this.toDoListGroup.remove(l);
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

    public void renameList() {
        //bring up popup window with string input box
        try {
            Parent renameListRoot = FXMLLoader.load(getClass().getResource("RenameListPopup.fxml"));
            Scene renameListPopup = new Scene(renameListRoot);
            Stage popup = null;
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setScene(renameListPopup);
            popup.setTitle("Rename List");
            popup.showAndWait();

            //call changeListName with selected ToDoList and returned string
            changeListName(toDoListGroup.get(0), RenameListPopupController.nameField.getText());
            //call updateViews
            updateViews();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeListName(ToDoList l, String s) {
        //call ToDoList.setTitle using l and s
        l.setTitle(s);
    }

    private void addItemToList(ToDoList l, String s1, String s2) {
        //call ToDoList.addItem using l, s1, and s2
        l.addItem(s1, s2);
    }

    public void removeItem() {
        boolean found = false;
        int foundIndex = 0;
        //check to see if a ToDoListItem is selected
        for(int i=0; i<ToDoListManagerController.listTreeTable.getExpandedItemCount(); i++) {
            if(ToDoListManagerController.listTreeTable.getSelectionModel().isSelected(i)) {
                found = true;
                foundIndex = i;
            }
        }
        if(found) {
            //find item in list
            for(int i = 0; i<toDoListGroup.get(0).list.size(); i++) {
                //call removeItem with selected ToDoList and ToDoListItem
                if(ToDoListManagerController.listTreeTable.getSelectionModel().getModelItem(foundIndex).equals(toDoListGroup.get(0).getItem(i))) {
                    toDoListGroup.get(0).removeItem(toDoListGroup.get(0).getItem(i));
                    break;
                }
            }
            //call updateViews
            updateViews();
        }
        //if not do nothing
    }

    private void removeItemFromList(ToDoList l, ToDoListItem li) {
        //call ToDoList.removeItem using l and li
        l.removeItem(li);
    }

    public void editItem() {
        boolean found = false;
        int foundIndex = 0;
        //check to see if a ToDoListItem is selected
        for(int i=0; i<ToDoListManagerController.listTreeTable.getExpandedItemCount(); i++) {
            if(ToDoListManagerController.listTreeTable.getSelectionModel().isSelected(i)) {
                found = true;
                foundIndex = i;
            }
        }
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
        boolean found = false;
        int foundIndex = 0;
        //check to see if a ToDoListItem is selected
        for(int i=0; i<ToDoListManagerController.listTreeTable.getExpandedItemCount(); i++) {
            if(ToDoListManagerController.listTreeTable.getSelectionModel().isSelected(i)) {
                found = true;
                foundIndex = i;
            }
        }
        if(found) {
            //find item in list
            for(int i = 0; i<toDoListGroup.get(0).list.size(); i++) {
                //call toggleComplete with selected ToDoListItem
                if(ToDoListManagerController.listTreeTable.getSelectionModel().getModelItem(foundIndex).equals(toDoListGroup.get(0).getItem(i))) {
                    toDoListGroup.get(0).list.get(i).toggleComplete();
                    break;
                }
            }
            //call updateViews
            updateViews();
        }
        //call toggleComplete using selected ToDoListItem
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
        //change the filter variable to represent the selected filter
        if(ToDoListManagerController.showAllFilter.isSelected()) {
            changeFilter("show all");
        } else if(ToDoListManagerController.showDoneFilter.isSelected()) {
            changeFilter("show done");
        } else if(ToDoListManagerController.showNotDoneFilter.isSelected()) {
            changeFilter("show not done");
        }
    }

    private void changeFilter(String p) {
        //set filter to p
        this.filter = p;
    }

    private void updateTable(ToDoList l) {
        //create puppet list in accordance with the Filters
        //create temporary root
        //iterate list adding each item to table view
        //set tableview to root
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
        for(ToDoList l : toDoListGroup) {
            //append ToDoList toStrings to string
            string += l.toString();
            //append \n after each ToDoList
            string += "\n";
        }
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

    //replace current ToDoList with new one



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
    private void updateList(Collection<ToDoList> c) {
        //set listTreeTable to c
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
    private Collection<ToDoList> parseFileCollection(File file) {
        Collection<ToDoList> temp = null;
        //have a parsing method here to create ToDoList objects with every line of file
        //store each object into temp collection
        return temp;
    }
    public ArrayList<ToDoList> addCollection(ArrayList<ToDoList> c1, ArrayList<ToDoList> c2) {
        ArrayList<ToDoList> temp = null;
        //set temp to c1.add(c2)
        return temp;
    }
    public void save() {
        //bring up popup to ask for which ToDoList to save
        //ask for String to name the file
        //overwrite or create file
        //print selected ToDoList's toString to file
        //close file
    }

    */
}
