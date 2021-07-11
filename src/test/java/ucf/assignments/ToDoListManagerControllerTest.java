/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListManagerControllerTest {

    @Test
    void can_add_new_list() {
        //initialize ToDoList Model
        //create empty toDoListGroup
        //call appendList with expected title string
        //assert toDoListGroup collection has ToDoList with expected title
    }

    @Test
    void can_remove_list() {
        //initialize ToDoList Model
        //create toDoListGroup populated with some number of ToDoList
        //call removeObjectFromList with one of the ToDoList objects
        //assert toDoListGroup collection properly removed the object
    }

    @Test
    void can_rename_list() {
        //initialize ToDoList Model
        //create toDoListGroup populated with one ToDoList
        //call changeListName using the just created ToDoList and an expected title
        //assert toDoListGroup has only one ToDoList with expected title
    }

    @Test
    void can_add_list_item() {
        //initialize ToDoListModel
        //populate toDoListGroup with one ToDoList
        //call addItemToList with created ToDoList and two expected strings
        //assert toDoList has ToDoListItem with expected strings
    }

    @Test
    void can_remove_list_item() {
        //initialize ToDoListModel
        //populate toDoListGroup with one ToDoList
        //populate ToDoList with some number of ToDoListItem
        //call removeItemFromList using created ToDoList and expected ToDoListItem
        //assert ToDoList no longer has expected ToDoListItem
    }

    @Test
    void can_edit_list_item_description() {
        //initialize ToDoListModel
        //populate toDoListGroup with one ToDoList
        //populate ToDoList with one ToDoListItem
        //call updateDescription using expected String
        //assert ToDoListItem has expected String as description
    }

    @Test
    void can_edit_list_item_due_date() {
        //initialize ToDoListModel
        //populate ToDoListGroup with one ToDoList
        //populate ToDoList with one ToDoListItem
        //call updateDate using expected String
        //assert ToDoListItem has expected String as date
    }

    @Test
    void can_mark_list_item_complete() {
        //initialize ToDoListModel
        //populate ToDoListGroup with one ToDoList
        //populate ToDoList with one ToDoListItem
        //call toggleComplete on ToDoListItem
        //assert ToDoListItem.complete is true
    }

    @Test
    void can_change_filter_to_SHOWALL() {
        //initialize ToDoListModel
        //call changeFilter with SHOWALL
        //assert that ToDoListModel.filter is equal to Filter.SHOWALL
    }

    @Test
    void can_change_filter_to_SHOWNOTDONE() {
        //initialize ToDoListModel
        //call changeFilter with SHOWNOTDONE
        //assert that ToDoListModel.filter is equal to Filter.SHOWNOTDONE
    }

    @Test
    void can_change_filter_to_SHOWDONE() {
        //initialize ToDoListModel
        //call changeFilter with SHOWDONE
        //assert that ToDoListModel.filter is equal to Filter.SHOWDONE
    }

    @Test
    void can_sort_ToDoList() {
        //initialize ToDoListModel
        //populate toDoListGroup with one ToDoList
        //populate ToDoList with at least two ToDoListItems
        //call sortItemList using created ToDoList
        //assert that ToDoList now has a sorted list of ToDoListItems
    }

    @Test
    void can_create_string_for_save_list_to_file() {
        //initialize ToDoListModel
        //populate toDoListGroup with one ToDoList
        //populate ToDoList with at least one ToDoListItem
        //call ToDoList.toString to get the printable string
        //assert printable string is equal to the expected string
    }

    @Test
    void can_create_bigString_for_save_all_lists_to_file() {
        //initialize ToDoListModel
        //populate toDoListGroup with at least one ToDoList
        //populate ToDoList with at least one ToDoListItem
        //call getBigString to get the big printable string
        //assert big printable string is equal to the expected string
    }

    @Test
    void can_append_external_collection_to_current_collection() {
        //initialize ToDoListModel
        //create ToDoList test and populate it with any number of ToDoListItems
        //call addList using the test Object to add the test ToDoList to the toDoListGroup
        //assert that toDoListGroup now contains every element from the test ToDoList
    }

    @Test
    void can_append_multiple_collections_to_current_collection() {
        //initialize ToDoListModel
        //create Collection<ToDoList> test and populate it with at least one ToDoList
        //call addCollection using toDoListGroup and test
        //assert that toDoListGroup now contains every element from test Collection
    }






}