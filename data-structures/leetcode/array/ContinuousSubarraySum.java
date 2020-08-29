package array;

import java.util.HashMap;

//LC-523
public class ContinuousSubarraySum {

    //Time Complexity - O(n)
    //Space Complexity - O(min(n,k)), the HashMap can contain upto min(n,k) different pairings
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
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
}
