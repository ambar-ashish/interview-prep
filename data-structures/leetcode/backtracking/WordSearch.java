package backtracking;

//LC-79
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0 , word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int count, String word){
        if(word.length() == count){
            return true;//Found the word
        }
        if(!isValid(board, i, j, count, word)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';//updated the board so that we do not visit the same cell again in current dfs iteration
        boolean exists = dfs(board, i+1, j, count+1 , word)  ||
                         dfs(board, i-1, j, count+1 , word)  ||
                         dfs(board, i, j+1, count+1 , word)  ||
                         dfs(board, i, j-1, count+1 , word);
        board[i][j] = temp;//updated back to original since the current dfs iteration is done
        return exists;
    }

    public boolean isValid(char[][] board, int i, int j, int count, String word){
        if(i<0 || i>=board.length || j<0
                || j>=board[i].length || board[i][j] != word.charAt(count)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word1 = "SEE";
        String word2 = "ABCB";
        System.out.println(wordSearch.exist(board, word1));//true
        System.out.println(wordSearch.exist(board, word2));//false
    }
}
//Time Complexity -> O(N*(3^L)) where N is the number of cells in the word and L is the length of the word
//For the backtracking function, initially we could have at most 4 directions to explore,
// but further the choices are reduced into 3 (since we won't go back to where we come from).
// As a result, the execution trace after the first step could be visualized as a 3-ary tree,
// each of the branches represent a potential exploration in the corresponding direction.
// Therefore, in the worst case, the total number of invocation would be the number of nodes in a
// full 3-nary tree, which is about 3^L
// We iterate through the board for backtracking,
// i.e. there could be N times invocation for the backtracking function in the worst case.
// As a result, overall the time complexity of the algorithm would be O(N*(3^L))

//Space Complexity - O(L) where L is the length of the word to be matched
//The main consumption of the memory lies in the recursion call of the backtracking function.
// The maximum length of the call stack would be the length of the word.

