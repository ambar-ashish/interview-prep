package heap;

import java.util.PriorityQueue;

//LC-252
public class MeetingRooms {

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

        for(int [] interval : intervals) {
            pq.add(interval);
        }

        int [] prev = pq.poll();
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
