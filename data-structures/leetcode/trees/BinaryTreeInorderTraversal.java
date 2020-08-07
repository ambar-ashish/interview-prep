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
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty())
                    break;
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

}
