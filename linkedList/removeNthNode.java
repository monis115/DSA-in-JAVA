
public class removeNthNode {
    public static Node start;

    class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
            this.next = null;
        }
    }

    public void remove(int n) {
        if (start == null)
            return;
        int size = 0;
        Node curNode = start;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }
        System.out.println(size);
        if (size == n) {// fisrt element to be DELED
            start = start.next;
            return;
        }
        int i = 1;
        int index = size - n;
        curNode = start;
        while (i != index) {
            curNode = curNode.next;
            i++;
        }
        curNode.next = curNode.next.next;

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

    public void printing() {
        Node curNode = start;
        while (curNode != null) {
            System.out.print(curNode.value + " ->");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        removeNthNode ll = new removeNthNode();
        ll.add(10);
        ll.add(102);
        ll.add(15);
        ll.add(4);
        ll.add(11);
        ll.printing();
        ll.remove(2);
        ll.printing();

    }

}
