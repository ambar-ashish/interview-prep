package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LC-56
public class MergeIntervals {

    //Time Complexity - O(nlogn)
    //Space Complexity - O(1)
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        result.add(prev);
        for (int[] curr : intervals) {
            // Overlapping intervals, move the end if needed
            if (curr[0] <= prev[1])
                prev[1] = Math.max(prev[1], curr[1]);
                // Disjoint intervals, add the new interval to the list
            else {
                prev = curr;
                result.add(prev);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    //My solution
    public int[][] mergeMySolvedSolution(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList();
        list.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] prev = list.get(list.size() - 1);
            if(prev[1] >= intervals[i][0]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }
        int[][] out = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            out[i] = list.get(i);
        }
        return out;
    }
}
