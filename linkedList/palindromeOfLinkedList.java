import javax.annotation.processing.SupportedOptions;

public class palindromeOfLinkedList {
    public static Node start;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
        }
        Node curNode = start;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        newNode.next = null;

    }

    public boolean isPalindrome() {
        if (start == null)
            return true;
        if (start.next == null)
            return true;
        Node FirstNode = start;
        Node middleNode = findMiddleNode(FirstNode);
        Node secondStart = reverseLinkedList(middleNode.next);
        while (secondStart != null) {
            if (FirstNode.data != secondStart.data)
                return false;
            FirstNode = FirstNode.next;
            secondStart = secondStart.next;
        }
        return true;
    }

    public Node findMiddleNode(Node FirstNode) {
        Node slow = FirstNode;
        Node fast = FirstNode;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;// this the middle Elemtn of the LinkedList
    }

    public Node reverseLinkedList(Node middleNode) {
        Node prevNode = middleNode;
        Node curNode = prevNode.next;
        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        middleNode.next = null;

        return prevNode;

    }

    public void printing(Node node) {
        Node curNode = node;
        while (curNode != null) {
            System.out.print(curNode.data + " ->");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        palindromeOfLinkedList list = new palindromeOfLinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.printing(start);
        System.out.println(list.isPalindrome());
    }

}
