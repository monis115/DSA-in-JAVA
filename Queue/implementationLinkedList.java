public class implementationLinkedList {
    public static Node start;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        public void insert(int data) {
            Node newNode = new Node(data);
            if (start == null) {
                start = newNode;
                return;
            }
            Node curNode = start;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }

        public int dequeue() {
            if (start == null)
                return -1;
            int front = start.data;
            start = start.next;
            return front;
        }

        public boolean isEmpty() {
            return start == null;
        }
    }

    public static void main(String args[]) {

        Queue q = new Queue();
        q.insert(15);
        q.insert(17);
        q.insert(19);
        q.insert(21);
        q.insert(23);
        q.dequeue();
        q.dequeue();
        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }

    }
}
