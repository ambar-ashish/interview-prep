package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//LC-973
public class KClosestPointstoOrigin {

    //Time Complexity: O(Nlogk)
    //Space Complexity: O(K)
    //The advantage of this solution is it can deal with real-time(online) stream data.
    //It does not have to know the size of the data previously.
    public int[][] kClosest(int[][] points, int K) {
        if(K>=points.length)
            return points;

        PriorityQueue<int[]> heap=new PriorityQueue<>
                ((p1,p2) -> getDistanceFromOrigin(p1) - getDistanceFromOrigin(p2));

        for(int[] point:points)
            heap.offer(point);

        int[][] result=new int[K][2];
        for(int i=0;i<K;i++)
            result[i]=heap.poll();
        return result;
    }

    private int getDistanceFromOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    //Time Complexity: O(NlogN)
    //Space Complexity: O(1)
    public int[][] kClosestUsingArrayBruteForce(int[][] points, int K) {
        if(points.length == 0){
            return new int[0][0];
        }
        if(K > points.length){
            return points;
        }
        Arrays.sort(points, ((p1, p2) -> getDistanceFromOrigin(p1) - getDistanceFromOrigin(p2)));
        int[][] output = new int[K][2];
        for(int i=0; i<K;i++){
            output[i][0] = points[i][0];
            output[i][1] = points[i][1];
        }
        return output;
    }

}
