package string;

//LC-1216
public class ValidPalindromeIII {

    //Optimal Solution is be using DP

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
}
