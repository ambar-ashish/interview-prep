package array;

//LC-26
public class RemoveDuplicatesfromSortedArray {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
