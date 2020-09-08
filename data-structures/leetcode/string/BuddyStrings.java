package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public boolean buddyStrings(String A, String B) {
        //If A.length() != B.length(): no possible swap
        if (A.length() != B.length())
            return false;
        //If A == B, we need swap two same characters. Check is duplicated char in A.
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()){
                s.add(c);
            }
            return s.size() < A.length();
        }
        //In other cases, we find index for A[i] != B[i]. There should be only 2 diffs and it's our one swap.
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i){
            if (A.charAt(i) != B.charAt(i))
                dif.add(i);
        }
        return dif.size() == 2 &&
                A.charAt(dif.get(0)) == B.charAt(dif.get(1)) &&
                A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}
