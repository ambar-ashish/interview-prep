package greedy;

//LC-55
public class JumpGame {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;
        for(int i=nums.length - 1; i>=0; i--){
            if(i+ nums[i] >= lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }
}
