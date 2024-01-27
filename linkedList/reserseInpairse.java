
public class reserseInpairse {
    public static Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void swap() {

        Node traverseNode = head;
        while (traverseNode != null && traverseNode.next != null) {
            int temp = traverseNode.data;
                traverseNode.data = traverseNode.next.data;
                traverseNode.next.data = temp;
                 traverseNode = traverseNode.next.next;
        }

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;

    }

    public void printList() {
        if (head == null) {
            System.out.println("Nothing to show list is empty");
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        reserseInpairse list = new reserseInpairse();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(45);
        list.addLast(6);
        list.printList();
        list.swap();
        list.printList();

    }

}
