package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//LC-252
public class MeetingRooms {

    //Time Complexity - O(nlogn) - This can be improved using heap
    //Space Complexity - O(1)
    public boolean canAttendMeetingsUsingArrays(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for(int i=0; i<intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }

    /**
     * Using a minimum heap to store all the intervals based on the start point.
     * Take the top element and compare its end time with the start time of next one.
     * If there exists overlapping, return false.
     * O(n) time, O(n) space where n is the length of the intervals array.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;

        PriorityQueue<int[]> pq = new PriorityQueue<>
                ((a,b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            pq.add(interval);
        }

        int[] prev = pq.poll();
        while(!pq.isEmpty()) {
            int [] curr = pq.poll();
            if(curr[0] < prev[1]) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
