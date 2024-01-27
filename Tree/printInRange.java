public class printInRange {
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

    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void printInBetween(int x, int y, Node root) {
        if (root == null) {
            return;
        }
        /// searching both sides since both all values are lies in left and Right
        /// Subtree
        if (x <= root.data && root.data <= y) {

            printInBetween(x, y, root.left);
            System.out.print(root.data + " ");
            printInBetween(x, y, root.right);

        }
        // search in right subtre since all values are right Subtree
        else if (x > root.data) {

            printInBetween(x, y, root.right);
        }
        // search in left subtree since all values are lies in left subtree
        else {

            printInBetween(x, y, root.left);
        }

    }

    public static void main(String args[]) {
        int node[] = { 8, 5, 3, 6, 4, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < node.length; i++) {
            root = insert(root, node[i]);
        }
        printInBetween(1, 6, root);

    }
}
