public class linledL {
    static Node start;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // add node as a first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
            return;
        }
        newNode.next = start;
        start = newNode;
    }

    // add node in the last
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

    // add after a Node
    public void addAfter(int data, int nodeNumber) {
        Node newNode = new Node(data);
        int c = 1;
        Node curNode = start;
        while (c != nodeNumber) {
            curNode = curNode.next;
            c++;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;

    }

    // add before a Node
    public void addBeforeNOde(int data, int nodeNumber) {
        Node newNode = new Node(data);
        int c = 1;
        Node curNode = start;
        while ((c) != nodeNumber - 1) {
            curNode = curNode.next;
            c++;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;

    }

    // deleting from the beg
    public void deleteFirst() {
        if (start == null) {
            System.out.println("No element to delete");
            return;
        }
        start = start.next;
    }

    // delete last element from the list;
    public void deleteLast() {
        if (start == null) {
            System.out.println("No element to delete");
            return;
        }
        Node curNode = start.next;
        Node prevNode = start;
        while (curNode.next != null) {
            curNode = curNode.next;
            prevNode = prevNode.next;

        }
        prevNode.next = null;

    }

    // deletion of item
    public void deleteItem(int item) {
        if (start == null) {
            System.out.println("UnderFlow");
            return;
        }
        Node curNode = start.next;
        Node prevNode = start;
        while (curNode.next != null && curNode.data != item) {

            prevNode = curNode;
            curNode = curNode.next;

        }
        if (curNode.data != item) {
            System.out.println("Not found! ");
            return;
        }
        if (start.data == item) {
            start = start.next;
        }
        prevNode.next = curNode.next;

    }

    // printing
    public static void printlist() {
        if (start == null) {
            System.out.println("Nothing to show list is empty");
            return;
        }
        Node curNode = start;
        while (curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        linledL list = new linledL();
        list.addFirst(5);
        list.addFirst(9);
        list.addFirst(11);
        list.addFirst(1);
        list.addFirst(0);
        printlist();
        list.addLast(14);
        list.addLast(15);
        list.addLast(16);
        list.addLast(17);
        printlist();
        // list.addAfter(1, 2);
        // list.addAfter(211, 1);
        // printlist();
        list.addBeforeNOde(99, 5);
        printlist();
        list.deleteFirst();
        printlist();
        list.deleteLast();
        printlist();
        list.deleteItem(199);
        printlist();

    }
}
