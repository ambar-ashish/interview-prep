package trees;

import java.util.Stack;

//LC-173
//Need to understand this better
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack =  null ;
    TreeNode current = null ;

    public BinarySearchTreeIterator(TreeNode root) {
        current = root;
        stack = new Stack<> ();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left ;
        }
        TreeNode t = stack.pop() ;
        current = t.right ;
        return t.val ;
    }
}
//the idea is same as using stack to do Binary Tree Inorder Traversal
