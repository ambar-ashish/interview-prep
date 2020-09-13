package array;

import java.util.HashMap;
import java.util.Map;

//LC-523
public class ContinuousSubarraySum {

    public boolean checkSubarraySumWithComments(int[] nums, int k) {
        // corner case 1: according to the question, the result's length has to be >=2
        if(nums.length<=1)
            return false;
        // corner case 2: when k is 0, we only need two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true. (k doesn't matter here)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0)
                return true;
        }
        // corner case 3: we already check the case where there are two consecutive 0, if k is 0, just return false.
        if(k==0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            sum = sum%k; //meaning k cannot be zero
            if(map.containsKey(sum))
            {
                int pre = map.get(sum);
                //the length of the subarray should be i-pre as the sum is from pre+1, pre+2, ..., i
                if(i - pre > 1)
                    return true;
            }else
                map.put(sum, i);
        }
        return false;
    }

    //Time Complexity - O(n)
    //Space Complexity - O(min(n,k)), the HashMap can contain upto min(n,k) different pairings
    /** Key point: if we can find any two subarray of prefix sum have same mod value, then their difference MUST be
     * divisible by k. So we can use a map to store mod value of each prefix sum in map, with its index. Then check
     * if map contains the same mod value with size > 2 when we have new mod value in every iteration */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        // corner case: if the very first subarray with first two numbers in array could form the result,
        // we need to put mod value 0 and index -1 to make it as a true case
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    public boolean checkSubarraySumSubOptimal(int[] nums, int k) {
        for(int i = 0; i < nums.length-1; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if ((k == 0 && sum == 0) || (k != 0 && sum % k == 0))
                    return true;
            }
        }
        return false;
    }



}
