package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//LC-253
public class MeetingRoomsII {

    //Time Complexity: O(NlogN)
    //Space Complexity: O(N)
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        if (n <= 1) return n;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // heap size will denote rooms occupied
        // value in each node will be meeting's end time of a room
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // add first interval's end time in heap
        pq.add(intervals[0][1]);

        for (int i = 1; i < n; i++)
        {
            // compare min end time with new interval's start time
            if (pq.peek() <= intervals[i][0])
            {
                // remove min end time from heap i.e. free this room for intervals[i]
                pq.poll();
                pq.add(intervals[i][1]);
            }
            else
                // occupy a new room for intervals[i]
                pq.add(intervals[i][1]);
        }

        return pq.size();
    }

}
