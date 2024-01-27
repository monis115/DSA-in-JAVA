
public class AddingInSortingList {
    public static Node start;

    class Node {
        int info;
        Node next;

        Node(int info) {
            this.info = info;
            this.next = null;
        }
    }

    public void insertionInSortingList(int item) {
        Node newNode = new Node(item);
        Node loc = findLoc(start, item);
        if (loc == null) {
            newNode.next = start;
            start = newNode;
            return;
        }
        newNode.next = loc.next;
        loc.next = newNode;

    }

    public Node findLoc(Node start, int item) {
        Node loc;
        if (start == null) {
            loc = null;
            return loc;
        }
        if (item < start.info) {
            loc = null;
            return loc;
        }
        Node prevNode = start;
        Node curNode = start;
        while (curNode != null) {
            if (item < curNode.info) {
                loc = prevNode;
                return loc;
            }
            prevNode = curNode;
            curNode = curNode.next;

        }
        loc = prevNode;
        return loc;

    }

    public void addFirst(int info) {
        Node newNode = new Node(info);
        if (start == null) {
            start = newNode;
            return;
        }
        newNode.next = start;
        start = newNode;

    }

    public static void printList() {
        if (start == null) {
            System.out.println("Nothing to show here list is empty");
        }
        Node currentNode = start;
        while (currentNode != null) {
            System.out.print(currentNode.info + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        AddingInSortingList list = new AddingInSortingList();
        list.addFirst(22);

        list.addFirst(21);
        list.addFirst(20);
        list.addFirst(10);
        printList();
        list.insertionInSortingList(5);
        printList();
        list.insertionInSortingList(19);
        printList();
        list.insertionInSortingList(50);
        printList();
        list.insertionInSortingList(18);
        printList();

    }
}
