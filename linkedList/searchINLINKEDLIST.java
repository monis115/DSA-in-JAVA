import java.util.*;

public class searchINLINKEDLIST {
    // function for search in LinkedList
    public static int search(int data, LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (data == list.get(i))
                return i + 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(0);
        list.add(3);

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
        System.out.println(search(15, list));
    }
}
