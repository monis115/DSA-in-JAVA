import java.util.HashSet;
import java.util.Iterator;

public class Hashing {
    public static void main(String args[]) {
        // creation Of Hashset same as ArrayList<Integer> list=new ArrayList<.()
        HashSet<Integer> set = new HashSet<>();
        // Insertion
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(17);
        set.add(5);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(5);
        // printing
        // Not necessary as same order as we Added
        System.out.println(set);

        // Searching
        // contains Functions
        if (set.contains(5)) {
            System.out.println(" Conatins 5");
        } else {
            System.out.println("Does Not Contains 5 ");
        }
        // Deletion
        // Remove Function
        set.remove(5);
        if (set.contains(5)) {
            System.out.println("Conatins 5");
        } else {
            System.out.println("Does Not Contains 5");
        }
        // Size Of Set
        System.out.println("Set Size is -> " + set.size());

        // Iterator
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}