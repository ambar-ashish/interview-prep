package trees;

import java.util.LinkedList;
import java.util.Queue;

//LC-938
public class RangeSumOfBST {

    //Time Complexity - O(N)
    //Space Complexity - O(H)
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0; // base case.
        if (root.val < L)
            return rangeSumBST(root.right, L, R); // left branch excluded.
        if (root.val > R)
            return rangeSumBST(root.left, L, R); // right branch excluded.
        return root.val + rangeSumBST(root.right, L, R) +
                rangeSumBST(root.left, L, R); // count in both children.
    }

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public int rangeSumBSTSubOptimal(TreeNode root, int L, int R) {
        if (root == null)
            return 0; // base case.
        int sum = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.remove();
            if(current.val >= L && current.val <= R){
                sum += current.val;
            }
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
        }
        return sum;
    }
}
