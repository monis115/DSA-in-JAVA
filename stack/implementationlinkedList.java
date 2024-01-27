public class implementationlinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class stack {
        static Node head = null;

        public boolean isEmpty() {
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

        public Node pop() {
            if (isEmpty()) {
                return null;
            }
            head = head.next;
            return head;
        }

        public int  peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        stack s = new stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
