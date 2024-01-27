import java.util.ArrayList;

public class priorityQueue {

    static class heap {
        ArrayList<Integer> list = new ArrayList<>();

        // adding elemets in the list in asceding order
        public void add(int data) {

            list.add(data);
            int x = list.size() - 1;
            int parent = (x - 1) / 2;
            while (list.get(x) < list.get(parent)) {
                int temp = list.get(x);
                list.set(x, list.get(parent));
                list.set(parent, temp);
                x = parent;
                parent = (x - 1) / 2;
            }

        }

        public int remove() {
            int data = list.get(0);
            int temp = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.set(list.size() - 1, temp);
            list.remove(list.size() - 1);// removing the min element now present at the last idex of the LastINdex
            heapify(0);
            return data;

        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = i;
            if (left < list.size() - 1 && list.get(left) < list.get(min))
                min = left;
            if (right < list.size() && list.get(right) < list.get(min))
                min = right;
            while (min != i) {
                int temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);

                heapify(min);
            }

        }

        public int peek() {
            return list.get(0);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    public static void main(String args[]) {
        heap pq = new heap();
        pq.add(10);
        pq.add(11);
        pq.add(1);
        pq.add(5);
        pq.add(7);
        pq.add(0);
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }

    }
}
