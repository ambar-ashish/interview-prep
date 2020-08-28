package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//LC-349
public class IntersectionofTwoArrays {

    //Time Complexity - O(n+m)
    //Space Complexity - O(n+m)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet();
        for(int i : nums1){
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet();
        for(int i : nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        int[] output = new int[set2.size()];
        int counter = 0;
        for(int i : set2){
            output[counter++] = i;
        }
        return output;
    }
}
