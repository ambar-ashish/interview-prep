package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//LC-269
public class AlienDictionary {

    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        HashMap<Character, HashSet<Character>> graph = new HashMap();
        buildGraph(graph, words, indegree);
        return bfs(graph, indegree);
    }

    public void buildGraph(HashMap<Character, HashSet<Character>> graph,
                           String[] words, int[] indegree){
        for(String word: words){
            for(char c : word.toCharArray()){
                graph.put(c, new HashSet());
            }
        }
        for(int i=1; i < words.length; i++){
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());

            for(int j=0; j<len; j++){
                if(first.charAt(j) != second.charAt(j)){
                    char out = first.charAt(j);
                    char in = second.charAt(j);

                    if(!graph.get(out).contains(in)){
                        graph.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    break;
                }
                if (j + 1 == len && first.length() > second.length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }

    public String bfs(HashMap<Character, HashSet<Character>> graph, int[] indegree){
        StringBuilder sb = new StringBuilder();
        int totalChars = graph.size();

        Queue<Character> q = new LinkedList();
        for(char c : graph.keySet()){
            if(indegree[c - 'a'] == 0){
                sb.append(c);
                q.offer(c);
            }
        }

        while(!q.isEmpty()){
            char curr = q.poll();
            if(graph.get(curr) == null || graph.get(curr).size() == 0)
                continue;
            for(char neigh : graph.get(curr)){
                indegree[neigh - 'a']--;
                if(indegree[neigh - 'a'] == 0){
                    q.offer(neigh);
                    sb.append(neigh);
                }
            }
        }
        return sb.length() == totalChars ? sb.toString() : "";
    }
}
