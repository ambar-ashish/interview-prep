package backtracking;

import java.util.*;

//LC-127
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;//Keeping the count of no of words transformed

        while (!queue.isEmpty()) {
            int size = queue.size();//getting all the words for the current iteration
            for (int i = 0; i < size; i++) {
                char[] current = queue.poll().toCharArray();
                for (int j = 0; j < current.length; j++) {//checking for the current word
                    char tmp = current[j];
                    for (char c = 'a'; c <= 'z'; c++) {//modifying and verifying one letter at a time
                        current[j] = c;
                        String next = new String(current);
                        if (set.contains(next)) {//verifying anf updating our set
                            if (next.equals(endWord)) return count + 1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    current[j] = tmp;//updating back for next change of letter
                }
            }
            count++;//this iteration ended with one letter change
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord = "hit";
        String endWord = "cog";
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));//5
    }
}

//Need to work on this, not sure as of now
//Time Complexity - O(L*N) where L is average length of the word and N is the number of words the list
//Space Complexity - O(N)
