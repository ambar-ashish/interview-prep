package array;

//LC-11
public class ContainerWithMostWater {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
            int min = Math.min(height[i], height[j]);
            max = Math.max(max, min * (j-i));
            //we try to check for more water, so we try to move either i or j whichever is shorter
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
