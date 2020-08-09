package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//LC-785
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1)
                if (!bfs(graph, color, i))
                    return false;
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        color[source] = 0;

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph[from]) {
                if (color[to] == color[from]) return false;
                if (color[to] == -1) {
                    color[to] = 1 - color[from]; // Handle opposite colors
                    queue.offer(to);
                }
            }
        }
        return true;
    }
}

//Time Complexity: O(V+E), where E is the number of edges in the input array and V is the number of nodes in the graph.
// We have to go through all the edges to build the adj graph and then possibly color each node to verify bipartite property.
//Space Complexity: O(V), space used to store the color
