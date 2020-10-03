package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//LC-94
public class BinaryTreeInorderTraversal {

    //Recursive Approach
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList();
        return traversal(root, list);
    }

    public List<Integer> traversal(TreeNode root, List<Integer> list){
        if(root == null){
            return list;
        }
        list = traversal(root.left, list);
        if(root != null){
            list.add(root.val);
        }
        list = traversal(root.right, list);
        return list;
    }

    //Iterative approach
    public List < Integer > inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

}
