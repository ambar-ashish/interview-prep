package heap;

import java.util.PriorityQueue;

//LC-703
public class KthLargestElementinaStream {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        for (Integer i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
