package array;

//LC-152
public class MaximumProductSubarray {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int currentMax = nums[0];
        int currentMin = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;

            currentMax = Math.max(nums[i], Math.max(currentMax*nums[i], currentMin*nums[i]));
            currentMin = Math.min(nums[i], Math.min(temp*nums[i], currentMin*nums[i]));

            finalMax = Math.max(currentMax, finalMax);
        }
        return finalMax;
    }
}
