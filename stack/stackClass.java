public class stackClass{
    public static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        public static Node head = null;;

        public void push(int data) { // push on the top of stack
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }   
            newNode.next = head;
            head = newNode;
        }

        public boolean isEmpty() {
            return head == null;

        }

        public int pop() { // pop from the top of the stack ...delete from the top of the stack
            if (isEmpty()) {
                return -1;
            }
            Node top = head;
            head = head.next;
            return top.data;
        }

        public int peek() { // to get the data on the top of stack
            if (isEmpty()) {
                return -1;
            }
            Node top = head;
            return top.data;       }

    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            System.out.println(s.pop());
        }

    }

}
