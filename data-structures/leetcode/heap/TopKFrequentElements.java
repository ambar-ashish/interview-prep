package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//LC-347
public class TopKFrequentElements {

    //Time Complexity - O(Nlogk)
    //Space Complexity - O(N+k)
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0 ; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) ->
                map.get(a) - map.get(b));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for(int i : map.keySet()){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }

        // 3. build an output array
        // O(k log k) time
        int[] output = new int[k];
        int counter = 0;
        while(!minHeap.isEmpty()){
            output[counter++] = minHeap.remove();
        }
        return output;
    }

    //Other solution can be QuickSelect, BucketSort and using TreeMap
}
