import java.util.LinkedList;

import java.util.ArrayList;

public class ImplementationOfHashMap {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n;
        private int N;
        private LinkedList<Node> Buckets[];

        HashMap() {
            this.N = 6;
            this.Buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                Buckets[i] = new LinkedList<>();// creating a empty linked list
            }
        }

        private int hashFunction(K key) {
            int BucketIndex = hashCode();
            return Math.abs(BucketIndex) % N;
        }

        private int searchinLinkedList(K key, int BucketIndex) {
            LinkedList<Node> ll = Buckets[BucketIndex];
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
            if (dataIndex == -1) { // does not exist
                Buckets[bucketIndex].add(new Node(key, value));
                n++;

            } else {
                Node node = Buckets[bucketIndex].get(dataIndex);
                node.value = value;

            }
            double lamda = (double) n / N;
            if (lamda > 2.0) {
                rehash();
            }

        }

        private void rehash() {
            LinkedList<Node> oldBuckets[] = Buckets;
            Buckets = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                Buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = Buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        public V get(K key) {
            int BucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, BucketIndex);
            if (dataIndex == -1) {
                return null;
            } else {
                Node node = Buckets[BucketIndex].get(dataIndex);
                return node.value;
            }
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
            int BucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, BucketIndex);
            if (dataIndex == -1) {
                return null;
            } else {
                Node node = Buckets[BucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Roll no  " + " Marks");
        map.put(1, 90);
        map.put(2, 80);
        map.put(3, 57);
        map.put(4, 89);
        map.put(5, 99);
        map.put(6, 98);
        map.put(7, 75);
        ArrayList<Integer> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " -> " + map.get(keys.get(i)));
        }
    }

}
