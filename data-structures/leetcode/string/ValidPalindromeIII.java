package string;

//LC-1216
public class ValidPalindromeIII {

    //SubOptimal Solution using Recursion
    public boolean isValidPalindromeUsingRecursion(String s, int k) {
        if(s.length() == 0){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        return isPalindrome(s, i, j, k);
    }

    public boolean isPalindrome(String s, int i, int j, int k){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                if(k<=0){
                    return false;
                }else{
                    return isPalindrome(s, i+1, j, k-1) || isPalindrome(s, i, j-1, k-1);
                }
            }
            i++;
            j--;
        }
        return true;
    }

    //Optimal Solution is be using DP
    //Time Complexity - O(N^2)
    //Space Complexity - O(N^2)
    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return s.length() <= k + dp[0][s.length() - 1];
    }
}

//dp[i][j]: the longest palindromic subsequence's length of substring(i, j),
//where i, j are left, right indices of the string.
//State transition:
//if s.charAt(i) == s.charAt(j):
//dp[i][j] = dp[i+1][j-1] + 2
//otherwise,
//dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]).
//dp[i][i] Initialized to 1.
