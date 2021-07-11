/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class ToDoListManagerController {

    @FXML private BorderPane borderPane;
    @FXML private Menu fileMenu;
    @FXML private Menu filterMenu;
    @FXML private RadioMenuItem showAllFilter;
    @FXML private ToggleGroup filterToggleGroup;
    @FXML private RadioMenuItem showDoneFilter;
    @FXML private RadioMenuItem showNotDoneFilter;
    @FXML private GridPane leftGridPane;
    @FXML private ListView<ToDoList> toDoListView;
    @FXML private GridPane rightGridPane;
    @FXML private TreeTableView<ToDoListItem> listTreeTable;
    @FXML private TreeTableColumn<ToDoListItem, Boolean> doneColumn;
    @FXML private TreeTableColumn<ToDoListItem, String> descriptionColumn;
    @FXML private TreeTableColumn<ToDoListItem, LocalDate> dateColumn;

    /* initialize
     * create ToDoListModel object
     * add example ToDoList to ToDoListView
     * set all column cell factories in tree table to receive the right information
     * descriptionColumn.setCellValueFactory(new PropertyValueFactory<ToDoListItem, String>("description"))
     * create dummy ToDoList and ToDoListItem
     * call updateViews
     */


    @FXML
    void addListButtonClicked(ActionEvent event) {
        //call addList
    }

    @FXML
    void removeListButtonClicked(ActionEvent event) {
        //call removeList
    }

    @FXML
    void renameListButtonClicked(ActionEvent event) {
        //call renameList
    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        //call addItem
    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        //call removeItem
    }

    @FXML
    void editItemButtonClicked(ActionEvent event) {
        //call editItem
    }

    @FXML
    void markCompleteButtonClicked(ActionEvent event) {
        //call completeToggle
    }

    @FXML
    void showAllFilterClicked(ActionEvent event) {
        //call updateFilter
    }

    @FXML
    void showDoneFilterClicked(ActionEvent event) {
        //call updateFilter
    }

    @FXML
    void showNotDoneFilterClicked(ActionEvent event) {
        //call updateFilter
    }

    @FXML
    void sortButtonClicked(ActionEvent event) {
        //call sort
    }

    @FXML
    void menuSaveListClicked(ActionEvent event) {
        //call save
    }

    @FXML
    void menuSaveAllClicked(ActionEvent event) {
        //call saveAll
    }

    @FXML
    void menuLoadListClicked(ActionEvent event) {
        //call load
    }

    @FXML
    void menuLoadCollectionClicked(ActionEvent event) {
        //call loadCollection
    }

}
