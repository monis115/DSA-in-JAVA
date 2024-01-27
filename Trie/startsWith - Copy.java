public class startsWith {
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

    public static boolean isStartWit(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];

        }
        return true;

    }

    public static void main(String args[]) {
        String word[] = { "apple", "mango", "orange", "guava" };
        for (int i = 0; i < word.length; i++)
            insert(word[i]);

        System.out.println(isStartWit("oro"));

    }

}
