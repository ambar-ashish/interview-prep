package graphs;

import java.util.*;

//LC-323
public class NumberofConnectedComponentsinanUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        if(n <=1){
            return n;
        }

        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (visited.add(entry.getKey())) {
                dfs(entry.getKey(), map, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited){
        for(Integer j : map.get(i)){
            if(visited.add(j)){
                dfs(j, map, visited);
            }
        }
    }
}

//Time : O(V + E)
//Space: O(V + E), (E is at most V^2 for sure)
//DFS is O(V) for both time and space, because basically you just DFS every vertex,
//and the Map and Set in DFS is just a reference.
