package graphs;

import org.w3c.dom.Node;

import java.util.*;

//LC-133
public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //Time Complexity - O(N) since we process each node exactly once
    //Space Complexity - O(N) -> Actually O(N) spcace occupied by Map + O(W) where W is the width of the graph created using BFD
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Queue<Node> q = new LinkedList();
        q.add(node);

        HashMap<Node, Node> cloneMap = new HashMap();
        Node newNode = new Node(node.val);
        cloneMap.put(node, newNode);
        while(!q.isEmpty()){
            Node tempNode = q.remove();
            for(Node neighbor : tempNode.neighbors){
                if(!cloneMap.containsKey(neighbor)){
                    cloneMap.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                cloneMap.get(neighbor).neighbors.add(cloneMap.get(tempNode));
            }
        }
        return cloneMap.get(node);
    }
}
