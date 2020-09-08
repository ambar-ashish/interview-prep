package array;

//LC-42
public class TrappingRainWater {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int trap(int[] height) {
        if (height.length==0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int leftMax=0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] > leftMax)
                leftMax = height[left];
            if (height[right] > rightMax)
                rightMax = height[right];
            if (leftMax < rightMax) {
                ans += leftMax-height[left];
                left++;
            } else {
                ans += rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
