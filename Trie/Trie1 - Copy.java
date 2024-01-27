
public class Trie1 {
    static class Node {
        Node[] children;
        boolean endOfWord;

        Node() {
            children = new Node[26];// this is for 26 letters
            for (int i = 0; i < 26; i++) {
                children[i] = null;// here we have initialized the Array to null
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();// THis is the root node

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();// adding a new Node
            }
            if (i == word.length() - 1) {
                curr.children[index].endOfWord = true;
            }
            curr = curr.children[index];
        }
    }

    // Function For Searchin
    public static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            if (i == key.length() - 1 && curr.children[index].endOfWord == false) {
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
            String firstPart = key.substring(0, i);// including all letters between 0 and i (i is not included)
            String secPart = key.substring(i);
            if (search(firstPart) && breakWord(secPart)) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];

        }
        return true;

    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);

            }
        }
        return count + 1;

    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    public static void main(String args[]) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
