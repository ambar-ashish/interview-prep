package array;

import java.util.Arrays;

public class MergeSortedArray {

    //Time Complexity - O(n+m)
    //Space Complexity - O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;
        while(p1 >= 0 && p2 >=0){
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // add missing elements from nums2
        for(int i=0 ; i<=p2; i++){
            nums1[i] = nums2[i];
        }
    }

    //Time Complexity - O((n+m)log(n+m))
    //Space Complexity - O(1)
    public void mergeSubOptimalSolution(int[] nums1, int m, int[] nums2, int n) {
        int x = 0;
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[x];
            x++;
        }
        Arrays.sort(nums1);
    }
}
