package tries;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//LC-1032
public class StreamofCharacters {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        boolean word = false;
    }

    TrieNode trie = new TrieNode();
    LinkedList<Character> stream = new LinkedList();

    public StreamofCharacters(String[] words) {
        for (String word : words) {
            TrieNode node = trie;
            String reversedWord = new StringBuilder(word).reverse().toString();
            for (char ch : reversedWord.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = true;
        }
    }

    public boolean query(char letter) {
        stream.addFirst(letter);

        TrieNode node = trie;
        for (char ch : stream) {
            if (node.word) {
                return true;
            }
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }
}
