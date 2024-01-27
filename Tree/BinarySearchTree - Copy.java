import java.util.*;

public class BinarySearchTree {
    // here we have Created Node
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

    // here we have cteated a binary tree
    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }
    }

    // This is preorderTraversal
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // This is inorderTraversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    // This is postorderTraversal
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // This is levelOrdertraversal->printing the nodes According to the Levels
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
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
                }
            } else {
                System.out.print(curNode.data + " ");
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }

            }
        }

    }

    // Functions For Counting the Nodes in a Binary Tree
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    // function to Calculate sum of Nodes
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);
        return leftsum + rightsum + root.data;
    }

    // Function To calculate Height
    public static int Height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = Height(root.left);
        int rightheight = Height(root.right);
        int maxheight = Math.max(leftheight, rightheight) + 1;
        return maxheight;
    }

    // diameter Of Tree
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = Height(root.left) + Height(root.right) + 1;
        return Math.max(Math.max(diameter2, diameter2), diameter3);

    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }

        public static TreeInfo diam2(Node root) {
            if (root == null) {
                return new TreeInfo(0, 0);
            }
            TreeInfo left = diam2(root.left);
            TreeInfo right = diam2(root.right);
            int myHeight = Math.max(left.ht, right.ht) + 1;
            int dia1 = left.diam;
            int dia2 = right.diam;
            int dia3 = left.ht + right.ht + 1;
            int mydiam = Math.max(Math.max(dia2, dia1), dia3);
            TreeInfo mInfo = new TreeInfo(myHeight, mydiam);
            return mInfo;
        }

        public static void main(String args[]) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.println(root.data);
            System.out.println("This is PREORDER TRAVERSAL");
            preorderTraversal(root);
            System.out.println("\nThis is INORDER TRAVERSAL");
            inorder(root);
            System.out.println("\nThis is POSTORDER TRAVERSAL");
            postorder(root);
            System.out.println("\nThis is Level Order traversal");
            levelOrder(root);
            System.out.println("\nThe Total Number of Nodes are ");
            System.out.println(countNodes(root));
            System.out.println("\nThe Sum Of All Nodes is ");
            System.out.println(sumOfNodes(root));
            System.out.println("The Height Of Tree is ");
            System.out.println(Height(root));
            System.out.println("The Diameter OF Tree is ");
            System.out.println(diam2(root).diam);

        }
    }
}