public class reverseIterative {
    public static Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void reverse() {
        Node prevNode = head;
        Node currrentNode = head.next;
        while (currrentNode != null) {
            Node nextNode = currrentNode.next;
            currrentNode.next = prevNode;
            prevNode = currrentNode;
            currrentNode = nextNode;

        }
        head.next = null;
        head = prevNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;

        }
        currentNode.next = newNode;

    }

    public void printList() {
        if (head == null) {
            System.out.println("Nothing to show here list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        reverseIterative list = new reverseIterative();
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.printList();
        list.reverse();
        list.printList();

    }
}
