
public class reverseLinkedList {
    static Node start;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void reverseIterative() {

        Node prevNode = start;
        Node curNode = prevNode.next;
        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        start.next = null;
        start = prevNode;
    }

    public Node reverseRecursive(Node start) {
        if (start == null || start.next == null) {
            return start;
        }

        Node newHead = reverseRecursive(start.next);
        start.next.next = start;
        start.next = null;
        return newHead;

    }

    public static void printList() {
        if (start == null) {
            System.out.println("Nothing to show here");
            return;
        }
        Node curNode = start;
        while (curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

    public void addLast(int data) {
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

    public static void main(String srgs[]) {
        reverseLinkedList list = new reverseLinkedList();
        list.addLast(5);
        list.addLast(56);
        list.addLast(57);
        list.addLast(58);
        list.addLast(59);
        printList();
        // list.reverseIterative();
        list.reverseRecursive(start);
        printList();

    }
}
