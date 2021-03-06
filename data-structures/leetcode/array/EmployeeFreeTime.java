package array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//LC-759
public class EmployeeFreeTime {

    //Overall, we don't need to care which interval belongs to which one.
    // Just put them all in one PQ, and merge the overlapped ones. Finally get the free period for everybody.
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) ->  a.start - b.start);

        for(List<Interval> intervals: schedule) {
            for(Interval interval: intervals) {
                pq.offer(interval);
            }
        }

        Interval pre = pq.poll();
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if(pre.end < cur.start) {
                res.add(new Interval(pre.end, cur.start));
            } else {
                cur.start = Math.min(pre.start, cur.start);
                cur.end = Math.max(pre.end, cur.end);
            }
            pre = cur;
        }
        return res;
    }

    //The idea is to just add all the intervals to the priority queue.
    //(NOTE that it is not matter how many different people are there for the algorithm.
    // becuase we just need to find a gap in the time line.
    //priority queue - sorted by start time, and for same start time sort by either largest end time
    // or smallest (it is not matter).
    //Everytime you poll from priority queue, just make sure it doesn't intersect with previous interval.
    //This mean that there is no common interval. Everyone is free time.
    public List<Interval> employeeFreeTimeComplexSolution(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for(List<Interval> intervals: schedule) {
            for(Interval interval: intervals) {
                pq.add(interval);
            }
        }

        Interval temp = pq.poll();
        while(!pq.isEmpty()) {
            if(temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            }else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
