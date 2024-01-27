public class linekdListss {
    public static Node start;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Insertion as FirstNode
    public void addFirst(int data) {
        Node newNode = new Node(data); // Node created
        if (start == null) { // LinkedList is empty
            start = newNode;
            return;
        }
        newNode.next = start;
        start = newNode;
    }

    // insertion as a lastNode
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            newNode.next = start;
        }
        Node curNode = start;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;

    }

    // insertion of Node after a given Node
    public void addAfterNOde(int data, int n) {
        Node newNode = new Node(data);
        int c = 1;
        Node curNode = start;
        while (c != n) {
            curNode = curNode.next;
            c++;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;
    }

    public void addBeforeNOde(int data, int n) {
        Node newNode = new Node(data);
        int c = 1;
        if (start == null) {
            newNode.next = start;
            start = newNode;
            return;
        }
        if (n == 1) {
            newNode.next = start;
            start = newNode;
            return;
        }
        Node currNode = start;
        while (c != n - 1) {
            currNode = currNode.next;
            c++;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;

    }
    // delete the FisrtNode

    public void remove() {
        if (start == null) {
            return;
        }
        start = start.next;

    }

    // delete the LastNode
    public void removeLast() {
        if (start == null) {
            return;
        }
        Node prevNode = start;
        Node currNode = start.next;
        while (currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;
    }

    public void addInSortedLL(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            newNode.next = start;
            start = newNode;
        }
        if (data < start.value) {
            newNode.next = start;
            start = newNode;
        }
        Node curNode = start;
        Node prevNode = start.next;
        while (curNode != null && data > curNode.value) {
            prevNode = curNode;
            curNode = curNode.next;

        }
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }

    public int search(int data) {
        if (start == null) {
            return -1;
        }
        if (data == start.value)
            return 1;
        int location = 1;
        Node curNode = start;
        while (curNode != null) {
            if (data == curNode.value) {
                return location;
            }
            location++;
            curNode = curNode.next;
        }
        return -1;
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

        linekdListss ll = new linekdListss();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(40);
        ll.addLast(48);
        ll.printing();
        ll.addInSortedLL(3);
        ll.addInSortedLL(50);

        ll.printing();
        ll.addInSortedLL(0);
        ll.printing();
        System.out.println(ll.search(50));
    }
}