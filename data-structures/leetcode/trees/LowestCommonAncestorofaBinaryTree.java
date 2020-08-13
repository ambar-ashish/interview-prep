package trees;

//LC-236
public class LowestCommonAncestorofaBinaryTree {

    //Need to understand this better
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}

//A modified version of pre-order traversal. The point to understand this is,
// once a sub-branch has a possible ancestor, all its super branches will have the same one.