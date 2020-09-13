package trees;

//LC-1026
public class MaximumDifferenceBetweenNodeandAncestor {

    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return result;
    }

    //Maintain a min and max seen so far as we explore the tree in DFS fashion.
    // At every node, we can update the result by comparing it with min and max.
    private void dfs(TreeNode curr, int max, int min) {
        if (curr != null) {
            result = Math.max(result, Math.abs(max - curr.val));
            result = Math.max(result, Math.abs(min - curr.val));
            dfs(curr.left, Math.max(max, curr.val), Math.min(min, curr.val));
            dfs(curr.right, Math.max(max, curr.val), Math.min(min, curr.val));
        }
    }
}
