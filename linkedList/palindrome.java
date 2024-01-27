
public class palindrome {
    static Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node findMiddlNode(Node head) {
        Node first = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            first = first.next;
        }
        return first;

    }

    public Node reverse(Node head) {
        Node curNode = head.next;
        Node preNode = head;
        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;

        }
        head.next = null;
        return preNode;
    }

    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node middle = findMiddlNode(head);
        Node secondHalfStart = reverse(middle.next);
        Node firstHalfHead = head;
        while (secondHalfStart != null) {
            if (firstHalfHead.data != secondHalfStart.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfStart = secondHalfStart.next;

        }
        return true;
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

    public void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        palindrome list = new palindrome();
        list.addLast(0);
        list.addLast(1);
        // list.addLast(1);
        // list.addLast(2);
        list.addLast(0);
        list.printList(head);
        System.out.println(list.isPalindrome(head));

    }
}
