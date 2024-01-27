
class linkdList {
    static Node head;
    public static int size;

    linkdList() {
        size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null; // in the begening when node is created node its next pionter is null -> no list
            size++; // will be created there
        }
    }

    // add at the begning
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) { // if list is empty
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add at the last of list
    public void addLast(String data) {
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

    // delete at beg
    public static void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty cant delete ");
            return;
        }
        head = head.next;
        size--;
    }

    // delete LAst
    public static void deleteLast() {
        if (head == null) {
            System.out.println("Cant delete");
            return;
        }
        size--;
        if (head.next == null) { /// if one element is present
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            secondLast = secondLast.next;
            lastNode = lastNode.next;
        }
        secondLast.next = null;
    }

    // printing
    public static void printList() {

        if (head == null) { // if list is empty
            System.out.println("List is empty");
        }
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + "->");

            curNode = curNode.next;
        }

        System.out.println("NULL");

    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        linkdList list = new linkdList();
        list.addFirst("a");
        list.addFirst("is");
        printList();
        list.addLast("list");
        printList();
        list.addFirst("This");
        printList();
        deleteLast();
        printList();
        deleteFirst();
        printList();
        System.out.println(list.getSize());
    }
}
