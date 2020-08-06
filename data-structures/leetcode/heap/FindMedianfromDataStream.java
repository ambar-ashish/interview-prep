package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//LC-295
public class FindMedianfromDataStream {

    //To find the median, we need to focus on the middle elements.
    //The key point is we do not need to maintain the entire sorted order for median.

    //Imagine a sorted array ~ maxHeap on left and minHeap on right will make sure
    // middle elements are in their correct position as long as we maintain their sizes equal (of course, not fully sorted).

    //addNum always adds to maxHeap and if sizes are not equal transfer the middle element to minHeap.
    // (just a convention to return appropriately in findMedian if sizes not equal).
    //Also make sure maxHeap.peek() is always smaller than minHeap.peek()
    // to keep the correct middle elements accessible all the time.

    //maxHeap on left, minHeap on right
    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;

    public FindMedianfromDataStream() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.remove());
        else if(maxHeap.peek() > minHeap.peek()){
            int n1 = maxHeap.remove(), n2= minHeap.remove();
            maxHeap.add(n2);
            minHeap.add(n1);
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek()+minHeap.peek())/2.0;
        else
            return minHeap.peek();
    }
}

/**
 * Your FindMedianfromDataStream object will be instantiated and called as such:
 * FindMedianfromDataStream obj = new FindMedianfromDataStream();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

