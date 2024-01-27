public class LongestWordWithAllPrefixes {
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

    static Node root = new Node();// empty Node

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

    static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));// type Casting
                if (temp.length() > ans.length()) {
                    ans = temp.toString();// we cant store the temp String to answer
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    public static void main(String args[]) {
        String word[] = { "a", "banana", "app", "apple", "appl", "apply", "ap" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }

}
