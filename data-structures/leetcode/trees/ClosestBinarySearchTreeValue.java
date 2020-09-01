package trees;

//LC-270
public class ClosestBinarySearchTreeValue {

    //Time complexity : O(H) since here one goes from root down to a leaf.
    //Space Complexity : O(1)
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
