package string;

import java.util.LinkedList;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        LinkedList<Character> list = new LinkedList();
        int max = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(list.contains(s.charAt(i))){
                while(list.contains(s.charAt(i)) && !list.isEmpty()){
                    list.removeFirst();
                }
                list.addLast(s.charAt(i));
            }else{
                list.addLast(s.charAt(i));
                max = Math.max(max, list.size());
            }
        }
        return max;
    }
}
