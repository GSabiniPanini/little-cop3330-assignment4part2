/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListManagerControllerTest {

    /* removed in part 2
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
    void can_append_multiple_collections_to_current_collection() {
        //initialize ToDoListModel
        //create Collection<ToDoList> test and populate it with at least one ToDoList
        //call addCollection using toDoListGroup and test
        //assert that toDoListGroup now contains every element from test Collection
    }
    @Test
    void can_create_string_for_save_list_to_file() {
        //initialize ToDoListModel
        //populate toDoListGroup with one ToDoList
        //populate ToDoList with at least one ToDoListItem
        //call ToDoList.toString to get the printable string
        //assert printable string is equal to the expected string
    }
    */
    @Test
    void can_initialize_100_items() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //loop to add 99 more items to todolistgroup.get(0)
        for(int i=1;i<100; i++) {
            test.toDoListGroup.get(0).addItem("2000-10-10", "name" + (i+1));
        }
        //set expected to given name for 100th item
        String expected = "name100";
        //set actual to name of 100th item
        String actual = test.toDoListGroup.get(0).getItem(99).getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void item_has_description() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //set expected to default description
        String expected = "Description";
        //set actual to description of item
        String actual = test.toDoListGroup.get(0).getItem(0).getDescription();
        assertEquals(actual, expected);
    }

    @Test
    void item_has_due_date() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //set toDoListGroup.get(0)'s date to 2002-01-14
        test.toDoListGroup.get(0).getItem(0).updateDate("2002-01-14");
        //assert 2002-01-14 = ToDoListItem date
        String expected = "2002-01-14";

        String actual = test.toDoListGroup.get(0).getItem(0).getDate();
        assertEquals(actual, expected);
    }

    @Test
    void can_add_list_item() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //add ToDoListItem to ToDoList
        test.toDoListGroup.get(0).addItem("yyyy-mm-dd", "test");
        //assert ToDoList contains 2 ToDoListItems
        int actual = test.toDoListGroup.get(0).list.size();
        assertTrue(actual==2);
    }

    @Test
    void can_remove_list_item() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //populate ToDoList with 2 ToDoListItem
        test.toDoListGroup.get(0).addItem("yyyy-mm-dd", "test");
        //call removeItemFromList using any of the ToDoListItem
        test.toDoListGroup.get(0).removeItem(test.toDoListGroup.get(0).list.get(1));
        //assert ToDoList contains 1 ToDoListItem
        int actual = test.toDoListGroup.get(0).list.size();
        assertTrue(actual==1);
    }

    @Test
    void can_clear_list() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //populate ToDoList with 2 ToDoListItem
        test.toDoListGroup.get(0).addItem("yyyy-mm-dd", "test");
        //call clearList()
        test.clearList();
        //assert ToDoList contains 0 ToDoListItems
        int actual = test.toDoListGroup.get(0).list.size();
        assertTrue(actual==0);
    }
    @Test
    void can_edit_list_item_description() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call updateDescription on ToDoListItem
        test.toDoListGroup.get(0).list.get(0).updateDescription("test");
        //assert ToDoListItem has expected String as description
        String actual = test.toDoListGroup.get(0).list.get(0).getDescription();
        assertEquals(actual, "test");
    }

    @Test
    void can_edit_list_item_due_date() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call updateDate on ToDoListItem
        test.toDoListGroup.get(0).list.get(0).updateDescription("2002-01-14");
        //assert ToDoListItem has expected String as date
        String actual = test.toDoListGroup.get(0).list.get(0).getDate();
        assertEquals(actual, "2002-01-14");
    }

    @Test
    void can_mark_list_item_complete() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call toggleComplete on ToDoListItem
        test.toDoListGroup.get(0).list.get(0).toggleComplete();
        //assert ToDoListItem.complete is true
        boolean actual = test.toDoListGroup.get(0).list.get(0).getStatus();
        assertEquals(actual, true);
    }

    @Test
    void can_mark_list_item_incomplete() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call toggleComplete on ToDoListItem
        test.toDoListGroup.get(0).list.get(0).toggleComplete();
        test.toDoListGroup.get(0).list.get(0).toggleComplete();
        //assert ToDoListItem.complete is true
        boolean actual = test.toDoListGroup.get(0).list.get(0).getStatus();
        assertEquals(actual, false);
    }

    @Test
    void can_change_filter_to_show_all() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call changeFilter with show all
        test.changeFilter("show all");
        //assert that ToDoListModel.filter is equal to show all
        String actual = test.getFilter();
        assertEquals(actual, "show all");
    }

    @Test
    void can_change_filter_to_show_not_done() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call changeFilter with show not done
        test.changeFilter("show not done");
        //assert that ToDoListModel.filter is equal to show not done
        String actual = test.getFilter();
        assertEquals(actual, "show not done");
    }

    @Test
    void can_change_filter_to_show_done() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call changeFilter with show done
        test.changeFilter("show done");
        //assert that ToDoListModel.filter is equal to show done
        String actual = test.getFilter();
        assertEquals(actual, "show done");
    }

    @Test
    void can_create_bigString_for_save_all_lists_to_file() {
        //initialize ToDoListModel
        ToDoListModel test = new ToDoListModel();
        //call getBigString to get the big printable string
        String actual = test.getBigString();
        //assert big printable string is equal to the expected string
        assertEquals("name 2002-01-14 Description false\n", actual);
    }

    @Test
    void can_replace_current_collection_with_external_collection() {
        //initialize ToDoListModel
        //create ToDoList test and populate it with any number of ToDoListItems
        //call replaceList using the test list
        //assert that toDoListGroup now contains every element from the test ToDoList
    }

    @Test
    void can_sort_ToDoList() {
        //initialize ToDoListModel
        //populate ToDoList with 2 ToDoListItems
        //call sortItemList using created ToDoList
        //assert that ToDoList now has a sorted list of ToDoListItems
    }

}