package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList();
        if(schedule.size() == 0){
            return list;
        }
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b) -> a.start - b.start);

        for(List<Interval> in : schedule){
            for(Interval i : in){
                heap.add(i);
            }
        }

        Interval prev = heap.poll();
        while(!heap.isEmpty()){
            Interval curr = heap.poll();
            if(prev.end < curr.start){
                list.add(new Interval(prev.end, curr.start));
            }else{
                curr.start = Math.min(prev.start, curr.start);
                curr.end = Math.max(prev.end, curr.end);
            }
            prev = curr;
        }
        return list;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
}

//The idea is to just add all the intervals to the priority queue. (NOTE that it is not matter how many different people are there for the algorithm. becuase we just need to find a gap in the time line.
//
//priority queue - sorted by start time, and for same start time sort by either largest end time or smallest (it is not matter).
//Everytime you poll from priority queue, just make sure it doesn't intersect with previous interval.
//This mean that there is no coomon interval. Everyone is free time.
