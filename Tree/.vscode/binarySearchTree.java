public class binarySearchTree {
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
  public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
  public static void prerderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorderTraversal(root.left);
        
        inorderTraversal(root.right);
    }
  public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        inorderTraversal(root.right);
         System.out.print(root.data + " ");
    }

    public static void main(String args[]) {
        int values[] = { 34,5,64,12,8,93,10 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
      
     System.out.println();
        inorderTraversal(root);
    }

}

