package trees;

//LC-765
public class SmallestSubtreewithalltheDeepestNodes {

    int deepestLevel = 0;
    TreeNode res = null;

    //First Root to Leaf: return the deep level of every node
    //Then Leaf to Root: only when the its left node and right node both have the deepthest level, update the result node
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) return level;

        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);

        int curLevel = Math.max(leftLevel, rightLevel);
        deepestLevel = Math.max(deepestLevel, curLevel);
        if (leftLevel == deepestLevel && rightLevel == deepestLevel)
            res = root;
        return curLevel;
    }
}

//check the below link
//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146782/Same-as-LCA-O(2N)
