package trees;

//LC-1026
public class MaximumDifferenceBetweenNodeandAncestor {

    int diff = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return diff;
    }

    //Maintain a min and max seen so far as we explore the tree in DFS fashion.
    // At every node, we can update the result by comparing it with min and max.
    public void dfs(TreeNode root, int max, int min){
        if (root != null){
            max = Math.max(root.val, max);
            min = Math.min (root.val , min);
            diff = Math.max (diff, max-min);
            dfs (root.left , max, min );
            dfs (root.right , max, min );
        }
    }


    public int maxAncestorDiffWithoutUsingGlobalVariables(TreeNode root) {
        int[] diff = new int[1];
        dfs(root, root.val, root.val, diff);
        return diff[0];
    }

    public void dfs(TreeNode root, int max, int min, int[] diff){
        if (root != null){
            max = Math.max(root.val, max);
            min = Math.min (root.val , min);
            diff[0] = Math.max (diff[0], max-min);
            dfs (root.left , max, min , diff);
            dfs (root.right , max, min , diff);
        }
    }
}
