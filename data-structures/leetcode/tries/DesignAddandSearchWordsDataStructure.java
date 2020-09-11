package tries;

import java.util.HashMap;
import java.util.Map;

//LC-211
public class DesignAddandSearchWordsDataStructure {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        boolean word = false;
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public DesignAddandSearchWordsDataStructure() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.'
     * to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.children.get(ch);
            }
        }
        return node.word;
    }
}
