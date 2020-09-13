package trees;

import java.util.Stack;

//LC-98
public class ValidateBinarySearchTree {

    //Time Complexity - O(N) since we visit each node exactly once
    //Space Complexity - O(N) to keep stack
    public boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (curr.val <= inorder)
                return false;
            inorder = curr.val;
            curr = curr.right;
        }
        return true;
    }

    //Time Complexity - O(N) since we visit each node exactly once
    //Space Complexity - O(N) since we keep up to the entire tree
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    boolean isBST(TreeNode root, Integer left, Integer right){
        if(root == null){
            return true;
        }
        if(left != null && left >= root.val){
            return false;
        }
        if(right != null && right <= root.val){
            return false;
        }
        if(!isBST(root.left, left, root.val)){
            return false;
        }
        if(!isBST(root.right, root.val, right)){
            return false;
        }
        return true;
    }
}
