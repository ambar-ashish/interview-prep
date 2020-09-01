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

    //Time Complexity - O(n)
    //Space Complexity - O(n)
    public void rotateUsingExtraArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    //Time Complexity - O(n)
    //Space Complexity - O(1)
    //n this approach, we firstly reverse all the elements of the array.
    //Then, reversing the first k elements followed by reversing the rest
    //n−k elements gives us the required result.
    public void rotateUsingReverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
