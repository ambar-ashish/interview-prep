package array;

//LC-53
public class MaximumSubarray {

    //Greedy Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            max = Math.max(currentSum, max);
        }
        return max;
    }

    //Kadane's algo
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int maxSubArrayUsingDP(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0){
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
