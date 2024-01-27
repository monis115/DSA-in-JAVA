public class DeleteNodeBST {
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

    public static Node deleteNode(Node root, int value) {
       
        
        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        }
        if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else { // in this scope we have found the key value in the BST
                 // case 1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if (root.left == null)
                return root.right;
            else if (root.right == null) {
                return root.left;
            }
            // case 3 Root has two children
            Node IS = inorderPreprocessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, value);

        }
        return root;
    }

    public static Node inorderPreprocessor(Node root) {
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
        int node[] = { 8, 5, 3, 6, 4, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < node.length; i++) {
            root = insert(root, node[i]);
        }
        inorderTraversal(root);
        System.out.println();
        deleteNode(root, 10);
        inorderTraversal(root);
    }
}
