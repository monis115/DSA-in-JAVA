import java.util.*;

public class sumofSubArray {
    public static void main(String args[]) {
        int array[] = { 4, 5, 0, -2, -3, 1 };
        int sum = 0;
        int answer = 0;
        int k = 5;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < array.length; j++) {
            sum += array[j];
            if (map.containsKey(sum - k)) {
                answer += map.get(sum - k);
            
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }

        }
        System.out.println(answer);
    }

}
