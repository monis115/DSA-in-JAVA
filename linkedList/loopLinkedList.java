public class loopLinkedList {
    static Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }
}
