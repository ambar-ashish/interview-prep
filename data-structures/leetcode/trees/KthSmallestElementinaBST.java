package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//LC-230
public class KthSmallestElementinaBST {

    //Time complexity : O(H+k)
    //Space complexity : O(H)
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {//while(true) can be used and remove last return statement
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                k--;
                if (k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    //Time complexity : O(N) to build a traversal.
    //Space complexity : O(N) to keep an inorder traversal
    public int kthSmallestSubOptimal(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        return list.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
