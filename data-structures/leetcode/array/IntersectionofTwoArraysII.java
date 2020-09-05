package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LC-350
public class IntersectionofTwoArraysII {

    //Time Complexity - O(nlogn + mlogm)
    //Space Complexity - O(n+m)
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < n && j < m){
            int a = nums1[i], b= nums2[j];
            if(a == b){
                list.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for(int k = 0; k < list.size();k++)
            ret[k] = list.get(k);
        return ret;
    }
}

//Classic two pointer iteration, i points to nums1 and j points to nums2.
// Because a sorted array is in ascending order, so if nums1[i] > nums[j],
// we need to increment j, and vice versa. Only when nums1[i] == nums[j],
// we add it to the result array. Time Complexity O(max(N, M)).
// Worst case, for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }.
// We will always iterate the longest array.
