package array;

import java.util.ArrayList;
import java.util.List;

//LC-57
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i ++) {
            /*1. No overlap and newInterval appears before current interval, add newInterval to result.*/
            if (intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = intervals[i];
            }
            /*2. Has overlap, update the newInterval to the merged interval.*/
            else if (intervals[i][1] >= newInterval[0]) {
                int start = Math.min(intervals[i][0], newInterval[0]);
                int end = Math.max(intervals[i][1], newInterval[1]);
                newInterval = new int[] {start, end};
            }
            /*3. No overlap and newInterval appears after current interval, add current interval to result.*/
            else ans.add(intervals[i]);
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] insertAnotherSolution(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        // 1. if an interval end before newInterval start, it can be added to output directly.
        // 2. if an interval overlapping with new Interval, merge it into new Interval. overlapping if an interval end after new Interval start and start before new Interval end.
        // 3  after all overlapping intervals processed, add the merged new Interval (or the original new interval if no interval meet #2 condition, i.e. no overlap)
        // 4. add the rest non overlapping intervals. all the rest have start after new interval end.

        int i = 0, N = intervals.length;
        while (i < N && intervals[i][1] < newInterval[0]) // #1
            l.add(intervals[i++]);

        while (i < N && intervals[i][0] <= newInterval[1]) { // #2
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }

        l.add(newInterval); // #3
        while (i < N) l.add(intervals[i++]);  // #4
        return l.toArray(new int[][]{});
    }
}
