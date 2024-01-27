public class stackDS {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static class stackClass {
        static Node head = null;

        boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;

        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            head = head.next;
            return head.data;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String args[]) {
        stackClass s = new stackClass();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
