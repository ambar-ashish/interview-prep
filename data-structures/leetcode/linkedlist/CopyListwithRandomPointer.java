package linkedlist;

import java.util.HashMap;

//LC-138
public class CopyListwithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    //Time Complexity - O(N)
    //Space Compelxity - O(N)
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copy = new HashMap();

        Node temp = head;
        while(temp != null){
            copy.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        Node temp1 = head;
        while(temp1 != null){
            Node temp2 = copy.get(temp1);
            temp2.next = copy.get(temp1.next);
            temp2.random =  copy.get(temp1.random);
            copy.put(temp1, temp2);
            temp1 = temp1.next;
        }
        return copy.get(head);
    }
}
