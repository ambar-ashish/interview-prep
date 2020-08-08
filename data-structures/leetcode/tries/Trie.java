package tries;

import java.util.HashMap;

//LC-208
public class Trie {

    class TrieNode{
        public boolean isWord;
        public HashMap<Character, TrieNode> childrenMap = new HashMap();
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.childrenMap.get(c) == null){
                curr.childrenMap.put(c, new TrieNode());
            }
            curr = curr.childrenMap.get(c);
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.childrenMap.get(c) == null){
                return false;
            }
            curr = curr.childrenMap.get(c);
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.childrenMap.get(c) == null){
                return false;
            }
            curr = curr.childrenMap.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("leet");
        trie.insert("leetcode");
        trie.insert("data");
        System.out.println(trie.search("leet"));//true
        System.out.println(trie.search("lee"));//false
        System.out.println(trie.startsWith("lee"));//true
    }
}
