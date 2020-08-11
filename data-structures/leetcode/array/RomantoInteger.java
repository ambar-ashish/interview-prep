package array;

import java.util.HashMap;

//LC-13
public class RomantoInteger {

    //Time Complexity - O(N)
    //Space Complexity - O(1), the map will be of constant size
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int output = 0;
        //moving from left to right
        for(int i=0; i<s.length(); i++){
            //We will add all the values from left to right
            output += map.get(s.charAt(i));
            //If the current value is less than next value than subtract current and subtract the same which was
            //added in the last step. So overall twice we will subtract the current value
            if(i != s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                output -= 2*map.get(s.charAt(i));
            }
        }
        return output;
    }
}
