import java.util.*;

public class MajorityElements {
    // function for Majority Elments
    public static void majorityElements(int num[]) {
        // 1. creating map for storing keys and Freq
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = num.length;
        System.out.println("N /3 =" + n / 3);
        // 2. Storing the keys and Values into the map
        for (int i = 0; i < n; i++) {
            if (map.containsKey(num[i])) {// if key/number Already exist then
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);// else freq of number will be 1 and put it into the map
            }
        }
        // 3. printing the values
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key + "-> " + map.get(key));
            }
        }

    }

    public static void main(String args[]) {
        int num[] = { 1, 3, 5, 1, 3, 1, 5, 1, 5, 5, 5, 5, 3, 3, 3, 4 };
        majorityElements(num);

    }

}
