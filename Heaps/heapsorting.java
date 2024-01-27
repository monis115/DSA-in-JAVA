import java.util.Scanner;

public class heapsorting {
    public static void heapify(int[] array, int i, int n) {
        int left = 2 * i + 1;// index of left Node
        int right = 2 * i + 2;// index of right node
        int max = i;
        if (left < n && array[max] < array[left])
            max = left;
        if (right < n && array[max] < array[right])
            max = right;
        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, max, n);
        }

    }

    public static void heapsort(int[] array) {
        int n = array.length;
        for (int i = n / 2; i >= 0; i--) {
            // now build a max heap for non leaf nodes
            heapify(array, i, n);

        }

        /// push the larget element at end ;
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // now hapify for ramining elements\
            heapify(array, 0, i);
        }
    }

    public static void main(String args[]) {
        System.out.println("Enter the Size of array :");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int array[] = new int[size];
        System.out.println("Enter the Array of size of " + size);
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        // calling a heapSort
        heapsort(array);
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
