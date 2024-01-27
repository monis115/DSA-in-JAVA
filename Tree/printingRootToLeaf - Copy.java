import java.util.*;

public class printingRootToLeaf {
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

    public static Node insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertNode(root.left, value);
        } else {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    /**
     * @param root
     * @param path
     */
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        // leaf Node
        if (root.left == null && root.right == null) {
            printPaths(path);
        } else {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);// backtracking

    }

    public static void printPaths(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int node[] = { 8, 5, 3, 6, 1, 4, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < node.length; i++) {
            root = insertNode(root, node[i]);
        }
        System.out.println("Here are Paths from Root to Leaf");
        printRoot2Leaf(root, new ArrayList<>());
    }
}
