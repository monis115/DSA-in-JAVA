import java.util.*;
import java.util.Iterator;

public class HashingMap {
    public static void main(String args[]) {
        // creating a Hashmap
        // key(Country) Value(Population)
        HashMap<String, Integer> map = new HashMap<>();
        // put function use to add key and values in map
        map.put("India", 1200);
        map.put("China", 1300);
        map.put("USA", 300);
        map.put("Australia", 200);
        // printing the map;
        System.out.println(map);
        // updating the map
        System.out.println("Updating the India's population ");
        map.put("India", 1000);
        System.out.println(map);

        // search
        // conatins-> return true or false
        if (map.containsKey("China")) {

            System.out.println("Conatins ");
        } else {
            System.out.println("Does not Contain");
        }
        // look into the value
        // .get() function
        System.out.println(map.get("China"));// Exist -> will return value
        System.out.println(map.get("Indonesia"));// Does not exixt will return -> Null
        // int array[] = { 5, 6, 7, 8, 10 };
        // for (int i = 0; i < array.length; i++) {
        // System.out.print(array[i] + " ");
        // }
        // System.out.println();
        // // same as
        // for (int val : array) {
        // System.out.print(val + " ");
        // }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            // System.out.print(e.getKey());
            // System.out.print("-> " + e.getValue());
            // System.out.println();

        }
        // through ketset
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "-> " + map.get(key));
        }

    }
}
