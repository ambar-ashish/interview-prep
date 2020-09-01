package array;

//LC-162
public class FindPeakElement {

    //Time Complexity - O(logN)
    //Space Complexity - O(1)
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int findPeakElementSubOptimalSolution(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
