import java.util.*;

public class iternerary {
    public static String getStart(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();// creating a reverse map
        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);// make every key->Value And value->key
        }
        for (String key : map.keySet()) {
            if (!revMap.containsKey(key)) { // this loop will check every key in the revmap
                return key;
            }
        }
        return null;

    }

    public static void main(String args[]) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Bengluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");
        String start = getStart(map);// getSatrt function will return Mumbai as Mumbai not in Destination
        while (map.containsKey(start)) {
            System.out.print(start + "-> ");
            start = map.get(start);// updating the start point
        }
        System.out.println(start);

    }

}
