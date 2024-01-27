import java.util.*;;

public class binarySeatchTree {
    static class Node {
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
        int index = -1;

        public Node buildTree(int node[]) {
            index++;
            if (node[index] == -1) {
                return null;
            }
            Node newNode = new Node(node[index]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    // PreorderTraversal
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // inorderTraversal
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    // postOrderTraversal
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // level order Traversal
    // printing the Nodes according to the level
    public static void levelOrdertraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node cuNode = q.remove();
            if (cuNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {
                System.out.print(cuNode.data + " ");
                if (cuNode.left != null) {
                    q.add(cuNode.left);
                }
                if (cuNode.right != null) {
                    q.add((cuNode.right));
                }

            }
        }

    }

    // counting no of Nodes
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    // sum of All Nodes
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    // height of Tree
    public static int TreeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = TreeHeight(root.left);
        int rightheight = TreeHeight(root.right);
        int maxheight = Math.max(leftheight, rightheight) + 1;
        return maxheight;
    }

    // Diamter of Tree
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = TreeHeight(root.left) + TreeHeight(root.right) + 1;
        return Math.max(Math.max(dia2, dia1), dia3);
    }

    public static void main(String args[]) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(node);
        System.out.println("Root Of The Binary Tree");
        System.out.println(root.data);
        System.out.println("\nPreOrder Traversal ");
        preorderTraversal(root);
        System.out.println("\nThis is InorderTraversal ");
        inorderTraversal(root);
        System.out.println("\nThis is Post Order Traversal ");
        postOrderTraversal(root);
        System.out.println("This is Level Order Traversal");
        levelOrdertraversal(root);
        System.out.println("Total No of Nodes are ->" + countNodes(root));
        System.out.println("The Sum of All Nodes -> " + sumNodes(root));
        System.out.println("Height Of Tree is -> " + TreeHeight(root));
        System.out.println("The Diameter Of tree is -> " + diameter(root));

    }

}
