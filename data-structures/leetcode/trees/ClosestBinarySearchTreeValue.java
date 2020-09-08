package trees;

//LC-270
public class ClosestBinarySearchTreeValue {

    //Time complexity : O(H) since here one goes from root down to a leaf.
    //Space Complexity : O(1)
    //it makes sense to use a binary search: go left if target is smaller than current root value,
    //and go right otherwise. Choose the closest to target value at each step.
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            root =  root.val > target ? root.left : root.right;
        }
        return closest;
    }
}
