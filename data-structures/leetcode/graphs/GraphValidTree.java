package graphs;

import java.util.*;

//LC-261
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        HashMap<Integer, List<Integer>> graph = new HashMap();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList();
        q.add(0);
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);
        while(!q.isEmpty()){
            int node = q.remove();
            for(Integer neighbour : graph.get(node)){
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                q.add(neighbour);
            }
        }
        return seen.size() == n;
    }
}

//Time Complexity - O(V+E)
//Space Complexity - O(V+E)
