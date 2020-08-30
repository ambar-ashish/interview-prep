package array;

import java.util.PriorityQueue;

//LC-215
public class KthLargestElementinanArray {

    //Time Complexity - O(Nlogk)
    //Space Complexity - O(k) to store the heap elements
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

    //Quick select can be used to get the solution in O(n) time
}
