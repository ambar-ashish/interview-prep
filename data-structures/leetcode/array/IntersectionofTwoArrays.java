package array;

import java.util.*;

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

    //Verify this
    //Time Complexity - O(mlogm +nlogn)
    public int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
