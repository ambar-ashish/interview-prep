package string;

//LC-125
public class ValidPalindrome {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;
        while(low < high){
            if(!Character.isLetterOrDigit(s.charAt(low))){
                low++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(high))){
                high--;
                continue;
            }
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }else{
                low++;
                high--;
            }
        }
        return true;
    }
}
