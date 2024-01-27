import java.util.*;

public class sumofNodesAtKthlevel {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int index = -1;

        public static Node insert(int node[]) {
            index++;
            if (node[index] == -1) {
                return null;
            }
            Node newNode = new Node(node[index]);
            newNode.left = insert(node);
            newNode.right = insert(node);
            return newNode;

        }
    }

    public static void sumOfNodes(Node root, int level) {
        int sum = 0;
        int i = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curNode = q.remove();

            if (curNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    i++;
                }

            } else {

                if (i == level) {
                    sum += curNode.data;
                }
                System.out.print(curNode.data + " ");

                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }

            }

        }
        System.out.println("\nThe Sum is -> " + sum);

    }

    public static void main(String args[]) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.insert(node);
        sumOfNodes(root, 3);
    }

}
