package array;

//LC-238
public class ProductofArrayExceptSelf {

    //Time Comlexity - O(N)
    //Space Complexity - O(N)
    public int[] productExceptSelfSubOptimalSolution(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for(int i=1; i<nums.length; i++){
            left[i] = nums[i-1] * left[i-1];
        }

        right[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            right[i] = nums[i+1] * right[i+1];
        }

        for(int i=0; i<nums.length; i++){
            left[i] = left[i] * right[i];
        }
        return left;
    }

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;
        for(int i=1; i<n; i++){
            output[i] = output[i-1] * nums[i-1];
        }

        int right = 1;
        for(int i=n-1; i>=0; i--){
            output[i] = output[i] * right;
            right = right * nums[i];
        }
        return output;
    }
}
