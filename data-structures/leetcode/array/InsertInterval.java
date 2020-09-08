package array;

import java.util.ArrayList;
import java.util.List;

//LC-57
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i ++) {
            /*1. No overlap and newInterval appears before current interval, add newInterval to result.*/
            //interval->[12,16], newInterval->[4,8]
            if (intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = intervals[i];
            }
            /*2. Has overlap, update the newInterval to the merged interval.*/
            //interval=[3,5], newInterval->[4,8]
            else if (intervals[i][1] >= newInterval[0])
                newInterval = new int[] {Math.min(intervals[i][0], newInterval[0]),
                        Math.max(intervals[i][1], newInterval[1]) };
                /*3. No overlap and newInterval appears after current interval, add current interval to result.*/
                //interval ->[1,2], newInterval->[4,8]
            else ans.add(intervals[i]);
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}
