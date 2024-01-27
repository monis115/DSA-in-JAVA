import java.util.ArrayList;

public class implentationHeap {

    public static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {

            // add at last index
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;

            }

        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = i;
            if (left < arr.size() - 1 && arr.get(min) > arr.get(left)) {
                min = left;
            }
            if (right < arr.size() - 1 && arr.get(min) > arr.get(right))
                min = right;

            if (min != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);
                heapify(min);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public int remove() {
            int data = arr.get(0);
            // swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // delete lastone
            arr.remove(arr.size() - 1);
            //
            // now heapify
            heapify(0);
            return data;

        }
    }

    public static void main(String args[]) {
        Heap heap = new Heap();
        heap.add(50);
        heap.add(10);
        heap.add(15);
        heap.add(0);
        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }
    }
}
