public class BST {
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

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.data) {
            return search(root.left, key);
        } else if (key == root.data) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static Node deleteNode(Node root, int value) {
        if (value < root.data) {
            return deleteNode(root.left, value);

        } else if (value > root.data) {
            return deleteNode(root.right, value);

        } else {// root.data=value
                // deleting the Node
                // case 1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);

        }
        return root;

    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 6, 4, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorderTraversal(root);
        // if (search(root, 7)) {
        // System.out.println("\nFound");
        // } else {
        // System.out.println("\nNot Found !");
        // }
        deleteNode(root, 5);
        System.out.println();
        inorderTraversal(root);
    }

}
