package array;

//LC-209
public class MinimumSizeSubarraySum {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                result = Math.min(result, i+1-left);
                sum -= nums[left];
                left++;
            }
        }
        return (result != Integer.MAX_VALUE) ? result : 0;
    }
}
