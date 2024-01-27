import java.util.ArrayList;
import java.util.LinkedList;

// this implemnetatio is created by Monis
public class HashMapImple {
    // Hashmap DSA of Type Generics
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n;// Totol No of nodes
        private int N;// Total of Buckets
        private LinkedList<Node> Buckets[];

        HashMap() {
            this.N = 5;
            this.Buckets = new LinkedList[5];
            for (int i = 0; i < N; i++) {
                Buckets[i] = new LinkedList<>();// creating a empty LinekdList in every bucket
            }
        }

        // function for rehasing
        public void rehash() {
            LinkedList<Node> oldBuckets[] = Buckets;
            Buckets = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                Buckets[i] = new LinkedList<>();
            }
            // picking up the linekd List one by one and put it into Bucket of Size double
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        private int hashFunction(K key) {
            int bucketIndex = hashCode();
            return Math.abs(bucketIndex) % N;
        }

        private int searchinLinkedList(K key, int bucketIndex) {
            LinkedList<Node> ll = Buckets[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;

        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) { // Does not exist
                Buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else {
                Node node = Buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }
            double lamda = (double) n / N;
            if (lamda > 2.0) {
                // rehashing -> Call a function for Rehashing
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {
                return null;
            }
            Node node = Buckets[bucketIndex].get(dataIndex);
            return node.value;

        }

        public boolean cotains(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {
                return null;
            } else {
                Node node = Buckets[bucketIndex].remove(dataIndex);
                return node.value;
            }
        }

        public ArrayList<K> ketSet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < Buckets.length; i++) {
                LinkedList<Node> ll = Buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }

            }
            return keys;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 1200);
        map.put("Pakistan", 700);
        map.put("Nepal", 500);
        map.put("China", 1250);
        map.put("Srilanka", 400);
        map.put("USA", 700);
        map.put("Brazil", 200);
        map.put("Canada", 100);
        map.put("Itlay", 500);
        ArrayList<String> keys = map.ketSet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + "-> " + map.get(keys.get(i)));
        }
        map.remove("China");
        System.out.println();
        System.out.println();
        System.out.println("This list is after removing");
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + "-> " + map.get(keys.get(i)));
        }
        System.out.println("Now we are getting the Value by get Funtion");

    }

}
