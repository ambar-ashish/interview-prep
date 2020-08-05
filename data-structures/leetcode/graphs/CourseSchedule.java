package graphs;

import java.util.*;

//LC-207
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];

        HashMap<Integer, List<Integer>> graph = new HashMap();

        for(int i=0; i<numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        int count = 0;

        for (int i = 0; i < numCourses; ++i) {
            if (inDegrees[i] == 0)  queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            if(graph.containsKey(course)) {
                for (int neigh : graph.get(course)) {
                    inDegrees[neigh] = inDegrees[neigh] - 1;
                    if (inDegrees[neigh] == 0) {
                        queue.offer(neigh);
                    }
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
