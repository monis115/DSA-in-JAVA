import java.util.PriorityQueue;

public class slidingWindow {
    public static class Pair implements Comparable<Pair> {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override // pover riding the Function
        public int compareTo(Pair p2) {
            return p2.val - this.val;// this is decending order
        }

    }

    public static void main(String args[]) {
        int array[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;// window size
        int res[] = new int[array.length - k + 1];// this is the size of Resultant array or window array
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(array[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i < array.length; i++) {
            while (pq.size() > 0 && pq.peek().index <= (i - k)) {
                pq.remove();

            }
            pq.add(new Pair(array[i], i));
            res[i - k + 1] = pq.peek().val;

        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

}
