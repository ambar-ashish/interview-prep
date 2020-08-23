package trees;

//LC-1026
public class MaximumDifferenceBetweenNodeandAncestor {

    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) return;
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);
        res = Math.max(res, max - min);
        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}
