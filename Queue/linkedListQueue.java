public class linkedListQueue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {

        Node head;
        Node tail;

        Queue() {
            this.head = null;
            this.tail = null;
        }

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // adding elements in the list
        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;

        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is already empty");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);

        while (!q.isEmpty()) {
            System.out.print("| " + q.peek() + " ");
            q.remove();
        }

    }
}