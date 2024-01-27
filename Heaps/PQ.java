import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(11);
        pq.add(8);
        pq.add(0);
        pq.add(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
        // to find the reverse Order of the PriorityQueue

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(10);
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(1);
        System.out.println("Reverse Order");
        while (!queue.isEmpty()) {
            System.out.print(" " + queue.remove());
        }

    }
}
