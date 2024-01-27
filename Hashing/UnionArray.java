import java.util.*;

public class UnionArray {
    public static void Union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\nSize OF Set is " + set.size());

    }

    public static void main(String args[]) {
        int array1[] = { 5, 7, 8, 9, 1, 2, 3 };
        int array2[] = { 8, 7, 8, 9, 11, 12, 55 };
        Union(array1, array2);

    }

}
