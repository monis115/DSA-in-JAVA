import java.util.Arrays;

public class minAbsoluteDIffrenceProblem {
    public static void main(String args[]) {
        int array1[] = { 1, 2, 3 };
        int array2[] = { 4, 1, 5 };
        Arrays.sort(array1);
        Arrays.sort(array2);
        int minSum = 0;
        for (int i = 0; i < array1.length; i++) {
            minSum += Math.abs(array1[i] - array2[i]);
        }
        System.out.println(minSum);

    }
}
