package trees;

//LC-236
public class LowestCommonAncestorofaBinaryTree {

    //Time Complexity - O(N)
    //Space Complexity - O(H)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            // found p or q or touch the ground
            return root;

        // search p and q from left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            // from root's left & right we found both p and q, so root is the LCA
            return root;
        else
            // left is not null means from left's left & right we found both p and q
            // so left is the LCA, otherwise, right is the answer
            return left != null ? left : right;
    }
}

//A modified version of pre-order traversal. The point to understand this is,
// once a sub-branch has a possible ancestor, all its super branches will have the same one.

//The problem has several possibilitie:
//both p and q are in this tree
//only p or q is in this tree
//neither p or q is in this tree
//
//If we divide the tree in half, there are several possibilities:
//both p and q are in this half
//only p or q is in this half
//neither p or q is in this half
//
//So the problem becomes smaller and smaller.
//
//We don't apply preorder in case p or q are not in the tree initially.