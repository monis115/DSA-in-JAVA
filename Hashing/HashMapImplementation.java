import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapImplementation {
    // in this Class We are creating DSA HashMap;
    static class HashMap<K, V> { // generics -> general Type Of data
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;// n-> No of Nodes
        private int N;// N-> Bucket
        private LinkedList<Node> bucket[];//

        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[N];
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bucketIndex = key.hashCode();// its may return any number 12546,-12458
            return Math.abs(bucketIndex) % N;// BucketIndex Value suppose to lie between 0 and N-1

        }

        private int searchinLinkedList(K key, int bucketIndex) {
            LinkedList<Node> ll = bucket[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }

            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                bucket[i] = new LinkedList<>(); // creating Empty Linked List
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);// if dataindex==-1 -> Not Found
            if (dataIndex == -1) {// key does not exist
                bucket[bucketIndex].add(new Node(key, value));
                n++;

            } else {// key exist
                Node node = bucket[bucketIndex].get(dataIndex);
                node.value = value;

            }

            double lamda = (double) n / N;
            if (lamda > 2.0) {
                // rehashing
                rehash();
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);// if dataindex==-1 -> Not Found
            if (dataIndex == -1) {// key does not exist
                return null;

            } else {// key exist
                Node node = bucket[bucketIndex].get(dataIndex);
                return node.value;

            }

        }

        public boolean contains(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);// if dataindex==-1 -> Not Found
            if (dataIndex == -1) {// key does not exist
                return false;

            } else {// key exist
                return true;
            }

        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);// if dataindex==-1 -> Not Found
            if (dataIndex == -1) {// key does not exist
                return null;

            } else {// key exist
                Node node = bucket[bucketIndex].remove(dataIndex);
                n--;
                return node.value;

            }

        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
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
        map.put("India", 1200);
        map.put("Nepal", 10);
        map.put("China", 1300);
        map.put("USA", 80);
        map.put("Srilanka", 45);
        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + "-> " + map.get(keys.get(i)));
        }
        map.remove("India");
        System.out.println(map.get("India"));

    }
}