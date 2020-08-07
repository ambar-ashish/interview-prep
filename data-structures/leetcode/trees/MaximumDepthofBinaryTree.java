package trees;

//LC-104
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        return Math.max(ldepth, rdepth) + 1;
    }

}
