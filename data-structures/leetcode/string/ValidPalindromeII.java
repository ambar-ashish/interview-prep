package string;

//LC-260
public class ValidPalindromeII {

    //Time Complexity - O(N) -> N is the number of characters in string--actually O(3N)
    //Space Complexity - O(1)
    public boolean validPalindromeOptimalSolution(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return isPallin(s, i+1, j) || isPallin(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPallin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    //Time Complexity - O(N^2) -> This needs to be optimized
    //Space Complexity - O(N)
    public boolean validPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        StringBuffer sb = new StringBuffer(s);
        for(int i=0; i<sb.length(); i++){
            sb = sb.deleteCharAt(i);
            if(isPallindrome(sb)){
                return true;
            }
            sb = new StringBuffer(s);
        }
        return false;
    }

    public boolean isPallindrome(StringBuffer sb){
        int low = 0;
        int high = sb.length() - 1;
        while(low < high){
            if(sb.charAt(low) != sb.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
