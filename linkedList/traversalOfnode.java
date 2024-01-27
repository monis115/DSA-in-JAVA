public class traversalOfnode {
    static Node start;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void printList() {
        if (start == null) {
            System.out.println("Nothing to show list is empty");
        }
        Node currentNode = start;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        start = node1;
        node1.next = node2;
        node2.next = node3;

        printList();

    }
}
