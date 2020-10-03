public class Solution {

    public int[] shift(int[] nums)
    {
        int i = 0;
        int j = nums.length - 1;
        while(i<j){
            if(nums[i] % 2 != 0){
                i++;
                continue;
            }
            if(nums[j] % 2 == 0){
                j--;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,4,1,5,9,10,12,14,19,21};
        int[] output = solution.shift(nums);
        System.out.println("aafaf");
    }
}
