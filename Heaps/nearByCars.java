import java.util.*;

public class nearByCars {

    // sorting of objects
    static class Points implements Comparable<Points> {
        int x;
        int y;
        int distsq;
        int index;

        Points(int x, int y, int distsq, int i) {
            this.x = x;
            this.y = y;
            this.y = distsq;
            this.index = i;
        }

        @Override
        public int compareTo(Points p2) {
            return this.distsq - p2.distsq;// ascending order
        }
    }

    public static void main(String args[]) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Points> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distsq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new Points(points[i][0], points[i][1], distsq, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().index);
        }
    }
}
