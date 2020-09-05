package trees;

//LC-98
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    boolean isBST(TreeNode root, Integer left, Integer right){
        if(root == null){
            return true;
        }
        if(left != null && left >= root.val){
            return false;
        }
        if(right != null && right <= root.val){
            return false;
        }
        if(!isBST(root.right, root.val, right)){
            return false;
        }
        if(!isBST(root.left, left, root.val)){
            return false;
        }
        return true;
    }
}
