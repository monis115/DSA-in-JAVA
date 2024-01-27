
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    public static Node head = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty() == true) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {
        if (isEmpty()) {

            return -1;
        }
        return head.data;
    }
}

public class stackClasss {

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + " ");
            stack.pop();
        }

    }

}
