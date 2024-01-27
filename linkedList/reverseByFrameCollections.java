import java.util.*;

public class reverseByFrameCollections {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.add(5);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
