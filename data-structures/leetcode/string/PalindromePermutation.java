package string;

import java.util.HashSet;
import java.util.Set;

//LC-266
public class PalindromePermutation {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public boolean canPermutePalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        Set<Character> set = new HashSet();
        for(int i=0; i<s.length(); i++){
            if(!set.add(s.charAt(i))){
                set.remove(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }
}
