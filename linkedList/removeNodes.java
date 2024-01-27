public class removeNodes {
    static Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node removeNthNode(Node start, int n) {
        if (start.next == null) {
            return null;
        }

        int size = 0;
        Node curNode = start;
        while (curNode != null) {
            curNode = curNode.next;
            size++;
        }

        if (size == n) {
            return start.next;
        }
        Node preNode = start;
        int i = 1;
        int index = size - n;
        while (i < index) {
            preNode = preNode.next;
            i++;

        }
        System.out.println("size of the list " + size);
        preNode.next = preNode.next.next;
        return start;
    }

    void addLast(int data) {
        Node neNode = new Node(data);
        if (head == null) {
            head = neNode;
            return;
        }
        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = neNode;
    }

    void prinList(Node start) {
        while (start != null) {
            System.out.print(start.data + " ->");
            start = start.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        removeNodes list = new removeNodes();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(34);

        list.prinList(head);
        Node newhead = list.removeNthNode(head, 5);
        list.prinList(newhead);

    }
}
