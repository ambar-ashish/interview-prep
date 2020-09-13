package binarysearch;

//LC-33
public class SearchinRotatedSortedArray {

    //Time Complexity - O(logn)
    //Space Complexity - O(1)
    //Using Same Approach from Sorted Array II
    public int search(int[] nums, int target) {
        int start  = 0, end = nums.length - 1;
        //check each num so we will check start == end
        //We always get a sorted part and a half part
        //we can check sorted part to decide where to go next
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            //if left part is sorted
            if(nums[start] <= nums[mid]){
                if(target < nums[start] || target > nums[mid]){
                    //target is in rotated part
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[start] > nums[mid]){
                //right part is rotated
                //target is in rotated part
                if(target < nums[mid] || target > nums[end]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    //Time Complexity - O(logn)
    //Space Complexity - O(1)
    public int searchOld(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // the left half is monotonic, yet still does not satisfy
                if (nums[left] <= nums[mid] && nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // the right half is monotonic, yet still does not satisfy
                if (nums[right] >= nums[mid] && nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
