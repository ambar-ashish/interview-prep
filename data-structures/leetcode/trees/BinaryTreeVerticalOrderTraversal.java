package trees;

import java.util.*;

//LC-314
public class BinaryTreeVerticalOrderTraversal {

    class Node {
        TreeNode root;
        int hd;
        public Node(TreeNode root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        if (root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            map.putIfAbsent(cur.hd, new ArrayList<>());
            map.get(cur.hd).add(cur.root.val);

            if (cur.root.left != null) {
                q.offer(new Node(cur.root.left, cur.hd - 1));
            }

            if (cur.root.right != null) {
                q.offer(new Node(cur.root.right, cur.hd + 1));
            }
        }
        return new ArrayList<>(map.values());
    }
}
