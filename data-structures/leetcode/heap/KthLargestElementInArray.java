package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//LC-215
public class KthLargestElementInArray {

    //Time Complexity -  O(NlogK)
    //The time complexity of adding an element in a heap of size k is O(logk), and we do it N times that means
    //O(Nlogk) time complexity for the algorithm
    //Space Complexity - O(K) to store the heap elements
    public int findKthLargest(int[] nums, int k) {

        //Default order is ascending order
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

    //Time Complexity - O(NlogN)
    //Space Complexity - O(1)
    public int findKthLargestBruteForce(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //Quick Select solution should also be done for O(N) time complexity
}
