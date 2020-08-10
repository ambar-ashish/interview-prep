package trees;

//LC-124
public class BinaryTreeMaximumPathSum {

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumHelper(root);
        return maxSum; // as maxSum will always store the result
    }

    public int maxSumHelper(TreeNode root) {

        // base case
        if (root == null) return 0;

        // recursing through left and right subtree
        int leftMax = maxSumHelper(root.left);
        int rightMax = maxSumHelper(root.right);

        // finding all the four paths and the maximum between all of them
        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);

        // Storing the result in the maxSum holder
        maxSum = Math.max(maxSum, maxAll);

        // returning the value if root was part of the answer
        return maxOneNodeRoot;

    }
}

//Source of the solution(very nicely explained)
//https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/389609/Full-Explanation-article-with-pseudo-code-Beats-JAVA-100-time-and-100-space-Solution
