package array;

//LC-34
public class FindFirstandLastPositionofElementinSortedArray {

    //Time Complexity - O(logN), 2 pass
    //Space Complexity - O(1)
    public int[] searchRangeMostOptimal(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstLast(nums, target, true);
        result[1] = findFirstLast(nums, target, false);
        return result;
    }

    //f(nums[mid] == target) idx = mid; Look at this step after the if_else conditions are done.
    // In FIndFirst, he makes idx move towards the lower index,
    // and in FIndLast he makes it move towards the higher index.
    // The loop doesn't exist even if the target is found, it moves to one end, (left==right) and then exits
    private int findFirstLast(int[] nums, int target, boolean first) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                idx = mid;
            if (target < nums[mid] || (first && target == nums[mid])) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return idx;
    }

    //Time Complexity - O(N), one pass
    //Space Complexity - O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] output = {-1,-1};
        if(nums.length == 0){
            return output;
        }
        boolean started = false;
        int counter = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target && started){
                counter++;
            }else if(nums[i] == target && !started){
                started = true;
                output[0] = i;
            }
        }
        output[1] = output[0] + counter;
        return output;
    }

    //Time Complexity - O(N), actuallt 2*N since 2 pass is happening
    //Space Complexity - O(1)
    public int[] searchRangeSubOptimal(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        // find the index of the leftmost appearance of `target`.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        // if the last loop did not find any index, then there is no valid range
        // and we return [-1, -1].
        if (targetRange[0] == -1) {
            return targetRange;
        }
        // find the index of the rightmost appearance of `target` (by reverse
        // iteration). it is guaranteed to appear.
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }
}
