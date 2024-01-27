public class swapPairWise {
    public static Node start;

    class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
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

    public Node reversePairise() {
        if (start == null)
            return null;
        Node prevNode = start;
        Node curNode = start.next;
        Node start = curNode;
        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prevNode;
            if (nextNode == null || nextNode.next == null) {
                prevNode.next = nextNode;
                break;
            }
            prevNode.next = nextNode.next;
            prevNode = nextNode;
            curNode = prevNode.next;

        }
        return start;

    }

    public void printing(Node node) {
        Node curNode = node;
        while (curNode != null) {
            System.out.print(curNode.value + " ->");
            curNode = curNode.next;
        }
        System.out.println();

    }

    public static void main(String args[]) {
        swapPairWise ll = new swapPairWise();
        ll.add(10);
        ll.add(102);
        ll.add(15);
        ll.add(4);
        ll.add(11);
        ll.printing(start);
        Node st = ll.reversePairise();
        ll.printing(st);

    }

}
