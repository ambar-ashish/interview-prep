package array;

//LC-1060
public class MissingElementinSortedArray {

    // Return how many numbers are missing until nums[idx]
    // Simple One Pass
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int missingNum = nums[i] - nums[i-1] - 1;
            if (k <= missingNum)
                return nums[i-1] + k;
            k = k - missingNum;
        }
        return nums[n-1] + k;
    }

    public static void main(String[] args) {
        MissingElementinSortedArray solution = new MissingElementinSortedArray();
        int[] nums = {4,7,9,10};
        int k = 1;
        System.out.println(solution.missingElement(nums, k));
    }
}
