public class sorthingByHeap {
    public static void heapify(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < n && arr[left] > arr[max])
            max = left;
        if (right < n && arr[right] > arr[max])
            max = right;
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, max, n);
        }

    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        // bulid max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // one by one push the largest element at the end
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify for the n-1 elements
            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 5, 1, 10, 20, 11 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
