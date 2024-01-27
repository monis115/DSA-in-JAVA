import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCollectionFrameWork {
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

    }

}
