import java.util.PriorityQueue;

public class waekestSoldiers {
    static class Row implements Comparable<Row> {
        int count;
        int index;

        public Row(int count, int i) {
            this.count = count;
            this.index = i;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.count == r2.count)
                return this.index - r2.index;
            else
                return this.count - r2.count;

        }
    }

    public static void main(String args[]) {
        int army[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++)

        {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));

        }
        for (int i = 0; i < k; i++) {
            System.out.print("row" + pq.remove().index);
            System.out.println();
        }

    }
}
