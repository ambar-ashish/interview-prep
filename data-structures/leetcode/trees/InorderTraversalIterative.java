package trees;

import java.util.Stack;

public class InorderTraversalIterative {

    public static void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }
}

//Algorithm
//Initialize an empty stack.
//
//Push the current node (starting from the root node) onto the stack. Continue pushing nodes to the left of the current node until a NULL value is reached.
//
//If the current node is NULL and the stack is not empty:
//
//Remove and print the last item from the stack.
//Set the current node to be the node to the right of the removed node.
//Repeat the second step of the algorithm.
//If the current node is NULL ​and the stack is empty, then the algorithm has finished.