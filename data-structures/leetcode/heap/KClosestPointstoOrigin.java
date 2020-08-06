package heap;

import java.sql.Time;
import java.util.PriorityQueue;

//LC-973
public class KClosestPointstoOrigin {

    //Time Complexity: O(Nlogk)
    //Space Complexity: O(K)
    public int[][] kClosest(int[][] points, int K) {
        if(K>=points.length)
            return points;

        PriorityQueue<int[]> heap=new PriorityQueue<>
                ((p1,p2) -> getDistance(p1) - getDistance(p2));

        for(int[] point:points)
            heap.offer(point);

        int[][] result=new int[K][2];
        for(int i=0;i<K;i++)
            result[i]=heap.poll();
        return result;
    }

    private int getDistance(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    //Quick Select can be one of the other solutions

}
