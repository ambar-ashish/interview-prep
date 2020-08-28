package array;

//LC-189
public class RotateArray {

    //Time Complexity - O(k*n)
    //Space Complexity - O(1)
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0 || k == nums.length){
            return;
        }
        if(k > nums.length){
            k = k % nums.length;
        }
        while(k>0){
            for(int i=nums.length-1; i>0; i--){
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
            }
            k--;
        }
    }
}
