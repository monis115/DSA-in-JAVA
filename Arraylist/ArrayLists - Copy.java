package Arraylist;

import java.util.ArrayList;

// import java.util.ArrayList;

// import java.util.Collections;

public class ArrayLists {
    public static void main(String args[]) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        // add elements in the array list
        System.out.println("Added Elements ");
        list1.add(1);
        list1.add(4);
        list1.add(60);
        list1.add(5);
        list1.add(0);
        System.out.println(list1);
        // to get elements from list
        System.out.println(" Get element at index 1");
        System.out.println(list1.get(1)); // here 1 is the index of the array list
        // add element in between
        System.out.println("add element at index 1 and elements is 10 ");
        list1.add(1, 10); // here 1 is the index number and 10 is the element
        System.out.println(list1);
        // to set an element
        System.out.println("Update the list by 101 at index 0");
        list1.set((0), 101);
        System.out.println(list1);
        // to remove/delete an element pass the index to remove function
        System.out.println("Deleteing the element at iindex 4");
        list1.remove(4);
        System.out.println(list1);
        // size of the list
        System.out.println("Size of the list");
        int Size = list1.size();
        System.out.println(Size);
        // loops on list
        // for (int i = 0; i < Size; i++) {
        // System.out.println(list1.get(i));
        // }
        // Collections.sort(list1);
        // System.out.println("Sorted List");
        // System.out.println(list1);

    }

}
