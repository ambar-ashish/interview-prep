package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {

    //Time Complexity - O(N^2)
    //Space Complexity - O(N)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
