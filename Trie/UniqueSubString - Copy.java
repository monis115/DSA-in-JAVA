public class UniqueSubString {

    public static class Node {
        Node[] children;
        boolean eow;

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            if (i == word.length() - 1) {
                curr.children[index].eow = true;
            }
            curr = curr.children[index];
        }

    }

    public static int countNodes(Node root) {
        Node curr = root;
        int count = 0;
        if (root == null) {
            return 0;
        }
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                count += countNodes(curr.children[i]);
            }

        }
        return count + 1;

    }

    public static void main(String args[]) {
        String str = "ababa";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
    }

}
