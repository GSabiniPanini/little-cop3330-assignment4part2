/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import com.sun.source.tree.Tree;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class ToDoListManagerController {

    @FXML private BorderPane borderPane;
    @FXML private Menu fileMenu;
    @FXML public static Menu filterMenu;
    @FXML public static ToggleGroup filterToggleGroup;
    @FXML public static RadioMenuItem showAllFilter;
    @FXML public static RadioMenuItem showDoneFilter;
    @FXML public static RadioMenuItem showNotDoneFilter;
    @FXML private GridPane leftGridPane;
    @FXML public static ListView<ToDoList> toDoListView = new ListView<>();
    @FXML private GridPane rightGridPane;
    @FXML public static TreeTableView<ToDoListItem> listTreeTable;
    @FXML private TreeTableColumn<ToDoListItem, Boolean> doneColumn;
    @FXML private TreeTableColumn<ToDoListItem, String> descriptionColumn;
    @FXML private TreeTableColumn<ToDoListItem, String> dateColumn;

    private ToDoListModel model;

    //initialize
    @FXML public void initialize() {
        //create ToDoListModel object
        this.model = new ToDoListModel();
        //add dummy list to ToDoListView
        toDoListView.getSelectionModel().getSelectedItems().add(model.toDoListGroup.get(0));
        //add listener for changing liss
        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoList>() {
            @Override
            public void changed(ObservableValue<? extends ToDoList> observable, ToDoList oldValue, ToDoList newValue) {
                System.out.println("Main list changed from " + oldValue.getTitle() + " to " + newValue.getTitle() + ".");
            }
        });
        //set all column cell factories in tree table to receive the right information
        descriptionColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("date"));
        doneColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("complete"));
        //add dummy ToDoListItem to treetableview
        TreeItem<ToDoListItem> root = new TreeItem<ToDoListItem>(new ToDoListItem("yyyy-mm-dd", "desc"));
        TreeItem<ToDoListItem> prompt = new TreeItem<ToDoListItem>(model.toDoListGroup.get(0).getItem(0));
        root.getChildren().add(prompt);
        listTreeTable.setRoot(root);
        //focus the item
        listTreeTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listTreeTable.getSelectionModel().selectFirst();
        // call updateViews
        model.updateViews();
    }

    @FXML
    void renameListButtonClicked(ActionEvent event) {
        //call renameList
        model.renameList();
    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        //call addItem
        model.addItem();
    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        //call removeItem
        model.removeItem();
    }

    @FXML
    void editItemButtonClicked(ActionEvent event) {
        //call editItem
        model.editItem();
    }

    @FXML
    void markCompleteButtonClicked(ActionEvent event) {
        //call completeToggle
        model.completeToggle();
    }

    @FXML
    void showAllFilterClicked(ActionEvent event) {
        //call updateFilter
        model.updateFilter();
    }

    @FXML
    void showDoneFilterClicked(ActionEvent event) {
        //call updateFilter
        model.updateFilter();
    }

    @FXML
    void showNotDoneFilterClicked(ActionEvent event) {
        //call updateFilter
        model.updateFilter();
    }

    @FXML
    void sortButtonClicked(ActionEvent event) {
        //call sort
        model.sort();
    }

    @FXML
    void menuSaveAllClicked(ActionEvent event) {
        //call saveAll
        model.saveAll();
    }

    @FXML
    void menuLoadListClicked(ActionEvent event) {
        //call load
        model.load();
    }

    @FXML
    void clearListButtonClicked(ActionEvent event) {
        //call clearList
        model.clearList();
    }

    /* removed in part 2
    @FXML
    void removeListButtonClicked(ActionEvent event) {
        //call removeList
    }
    @FXML
    void addListButtonClicked(ActionEvent event) {
        //call addList
    }
    @FXML
    void menuLoadCollectionClicked(ActionEvent event) {
        //call loadCollection
    }
    @FXML
    void menuSaveListClicked(ActionEvent event) {
        //call save
    }
    */
}
