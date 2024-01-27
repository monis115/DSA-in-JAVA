import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapIplemetationMonis {
    // creating a DSA of HashMap
    static class HashMap<K, V> {// generics -> general data Type
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;// Total No of Nodes
        private int N;// Total No of Buckets
        private LinkedList<Node> buckets[]; // created a Array Of LinekdList

        private HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];// Now set the Size of Array of LinekdList ->
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>(); // creating the Empty LinkedList in every bucket[i]
            }
        }

        private int hashFunction(K key) {
            int bucketIndex = hashCode(); // it will return any number
            return Math.abs(bucketIndex) % N;// bucket index suppose to lies bteween 0 and N-1;
        }

        private int searchinLinkedList(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;

        }

        public void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();// creating a empty linkedListOF Size
            }
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {// if does not exist
                buckets[bucketIndex].add(new Node(key, value));// adding a node into the linekd list
                n++;
            } else {
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;

            }
            double lamda = (double) n / N;
            if (lamda > 2) {
                // Now Rehashing
                rehash();
            }

        }

        // get Function return Null if not available return value if available
        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {// if does not exist
                return null;// retunring -1

            } else {
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;

            }

        }

        // return true if available othersewise return false
        public boolean conatins(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {// if does not exist
                return false;
            } else {
                return true;

            }
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);
            if (dataIndex == -1) {// if does not exist
                return null;
            } else {
                Node node = buckets[bucketIndex].remove(dataIndex);
                return node.value;

            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }

            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("TCS", 55000);
        map.put("Wipro", 45000);
        map.put("Mahindra", 10000);
        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + "->" + map.get(keys.get(i)));
        }
        System.out.println(map.get("TCS"));
        map.remove("TCS");
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + "->" + map.get(keys.get(i)));
        }
    }
}
