public class Linkdlistt {
    static Node start;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // adding int the beg of list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
            return;
        }
        newNode.next = start;
        start = newNode;

    }

    // add in the last of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
            return;
        }
        Node currentNode = start;
        while (currentNode.next != null) {
            currentNode = currentNode.next;

        }
        currentNode.next = newNode;
    }

    // add after a node
    public void addAfterNOde(int nodeNo, String data) {
        Node newNode = new Node(data);
        int c = 1;
        Node currentNode = start;
        while (c != nodeNo) {
            currentNode = currentNode.next;
            c++;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;

    }

    // add before a node
    public void addBeforeNOde(int nodeNo, String data) {
        Node newNode = new Node(data);
        int c = 1;

        Node prevNode = start;

        while (c != nodeNo - 1) {
            prevNode = prevNode.next;
            // curreNode = curreNode.next;
        }
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }

    // delet from the begning
    public void deleteFirst() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        start = start.next;

    }

    public void deleteLast() {
        if (start == null) {
            System.out.println("Cant delete");
            return;
        }
        Node secondLastNOde = start;
        Node lastNode = start.next;
        if (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNOde = secondLastNOde.next;
        }
        secondLastNOde.next = null;

    }
    // delete in the end

    // for printing the linked list
    public static void printList() {
        if (start == null) {
            System.out.println("Nothing to show here list is empty");
        }
        Node currentNode = start;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        Linkdlistt list = new Linkdlistt();

        list.addLast("khan");
        list.addFirst("name");
        list.addFirst("My");
        printList();

        list.addAfterNOde(2, "is");
        printList();
        list.addBeforeNOde(2, "hey");
        printList();
        list.addAfterNOde(2, "Hi");
        printList();

    }
}
