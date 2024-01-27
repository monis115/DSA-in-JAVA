import java.util.*;

public class IntersectionArray {
    public static void Intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set1 = new HashSet<>();
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) { // if matching
                System.out.print(arr2[i] + " ");
                count++;
            }
        }
        System.out.println("\n The Size of Intersection set is " + count);
    }

    public static void main(String args[]) {
        int array[] = { 5, 4, 5, 4, 1, 5, 7, 10, 87, 10 };
        int array2[] = { 8, 7, 4, 1, 2, 0, 10, 11, 20 };
        Intersection(array, array2);

    }
}