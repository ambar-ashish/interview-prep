package trees;

import java.util.LinkedList;
import java.util.Queue;

//LC-117
public class PopulatingNextRightPointersinEachNodeII {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0; i<count; i++){
                Node temp = q.remove();
                if(i != count-1){
                    temp.next = q.peek();
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return root;
    }

    public class Node {

        int val;
        public Node left;
        public Node right;
        public Node next;

        Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
