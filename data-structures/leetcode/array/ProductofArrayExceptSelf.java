package array;

//LC-238
public class ProductofArrayExceptSelf {

    //Using division when 0 is not present in the array
    public int[] productExceptSelfUsingDivision(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int total = 1;
        for(int i=0; i<n; i++){
            total *= nums[i];
        }
        for(int i=0; i<n; i++){
            output[i] = total / nums[i];
        }
        return output;
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

        int r = 1;
        for(int i=n-1; i>=0; i--){
            output[i] = output[i] * r;
            r = r * nums[i];
        }
        return output;
    }
}
