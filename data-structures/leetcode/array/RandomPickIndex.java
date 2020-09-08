package array;

import java.util.Random;

//LC-398
public class RandomPickIndex {

    int[] nums;
    Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums=nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int count = 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==target && rand.nextInt(count++)==0) {
                index = i;
            }
        }
        return index;
    }
}
