
public class BTinsertion {
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

    public static class binaryTree {
        public static int index = -1;

        public static Node insert(int node[]) {

            if (node[index] == -1) {
                return null;
            }
            Node newNode = new Node(node[index]);
            newNode.left = insert(node);
            newNode.right = insert(node);
            return newNode;
        }

    }

    public static void main(String args[]) {

    }
}
