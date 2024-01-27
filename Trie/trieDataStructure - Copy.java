
public class trieDataStructure {
    public static class Node {
        Node[] children; // children Array of Type Node
        boolean eow;// end of Word

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null; // set every node to null
            }
            eow = false;/// set end of word to False
        }
    }

    static Node root = new Node();// This is empty root Node
    // insertion Function

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
            curr = curr.children[index];// updating the Root Node
        }

    }

    public static boolean contains(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            if (i == key.length() - 1 && curr.children[index].eow == false) {
                return false;
            }
            curr = curr.children[index];

        }
        return true;

    }

    public static void main(String args[]) {
        String word[] = { "apple", "samsung", "app", "there" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        System.out.println(contains("apple"));
        System.out.println(contains("samsung"));
        System.out.println(contains("the"));

    }
}
