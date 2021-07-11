/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Glenroy Little
 */

package ucf.assignments;

import java.util.Comparator;

public class SortByDateComparator implements Comparator<ToDoListItem> {

    //compare two ToDoListItems and compare them lexicographically
    public int compare(ToDoListItem a, ToDoListItem b) {
        for(int i = 0; i<10; i++) {
            int s1_char = (int) a.getDate().charAt(i);
            int s2_char = (int) b.getDate().charAt(i);

            if (s1_char != s2_char) {
                return s1_char - s2_char;
            }
        }

        //if the dates are equal return a 0
        return 0;
    }
}
