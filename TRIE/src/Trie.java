public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("The Trie has been Created.");
    }

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) { //newNode
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node; //node value assigned
        }
        current.endOfString = true;
        System.out.println(word + " Successfully inserted");
    }

    //Search
    boolean searchTree(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                System.out.println(word + " does not exist.");
                return false;
            }
            current = node; //if loop continuous means all characters are present
        }
        if (current.endOfString) {
            System.out.println(word + " exists!");
            return true;
        } else {
            System.out.println(word + " is a prefix of another string.");
            return false;
        }
    }

    //Delete String

    //helper
    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        if (currentNode.children.size() > 1) { //case 1:some other prefix
            delete(currentNode, word, index + 1);
            return false;
        }
        if (index == word.length() - 1) {
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        if (currentNode.endOfString==true) {
            delete(currentNode, word, index + 1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index + 1);
        if (canThisNodeBeDeleted) {
            parentNode.children.remove(ch);
            return true;
        } else
            return false;
    }

    //delete
    void delete(String word) {
        if (searchTree(word)) {
            System.out.println(" - no more");
            delete(root, word, 0);
        }
    }
}
