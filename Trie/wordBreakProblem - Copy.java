public class wordBreakProblem {
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

    public static boolean search(String key) {
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

    public static boolean breakWord(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String first = key.substring(0, i);
            String second = key.substring(i);
            if (search(first) && breakWord(second)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String args[]) {
        String word[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        System.out.println(search("samsung"));
        System.out.println(breakWord("ilikesamsung"));

    }

}
