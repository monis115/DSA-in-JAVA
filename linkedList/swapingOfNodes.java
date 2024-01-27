class swapingOfNodes {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public Node swap(Node start) {
        if (start == null || start.next == null) { // if no node is present or only one is prrsent
            return start;
        }
        Node prevNode = start;
        Node curNode = start.next;
        start = curNode;

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
        swapingOfNodes list = new swapingOfNodes();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        list.printList(head);
        Node st = list.swap(head);
        list.printList(st);

    }

}
