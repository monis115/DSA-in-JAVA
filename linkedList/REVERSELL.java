public class REVERSELL {
    public static Node start;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void reverseLinkedList() {
        if (start == null) {
            return;
        }
        Node prevNode = start;
        Node curNode = start.next;
        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;

        }
        start.next = null;
        start = prevNode;

    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
        }
        Node curNode = start;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        newNode.next = null;

    }

    public void printing() {
        Node curNode = start;
        while (curNode != null) {
            System.out.print(curNode.value + " ->");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        REVERSELL ll = new REVERSELL();
        ll.add(10);
        ll.add(102);
        ll.add(15);
        ll.add(4);
        ll.add(11);
        ll.printing();
        ll.reverseLinkedList();
        ll.printing();

    }

}
