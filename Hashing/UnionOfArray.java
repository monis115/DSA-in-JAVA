import java.lang.Thread.State;
import java.util.*;

public class UnionOfArray {
    public static int count = 0;

    public static void Union(int arr1[], int arr2[]) {

        // 1. Create hashmap of integer and integer type
        HashMap<Integer, Integer> map = new HashMap<>();
        // 2. Traverse array1
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], 1);// putting all the Elemnts of arrray1 to the map
            count++;
        }
        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i])) { // adding only those elemts which are not present
                map.put(arr2[i], 1);
                count++;
            }
        }
        for (int key : map.keySet()) {
            System.out.print(key + " ");
        }

        System.out.println("\nTotal Number Of Elemets in Union is " + count);
    }

    public static void main(String args[]) {
        int array1[] = { 1, 2, 3, 4, 5, 67 };
        int array2[] = { 11, 1, 2, 4, 9, 7 };
        Union(array1, array2);

    }

}
