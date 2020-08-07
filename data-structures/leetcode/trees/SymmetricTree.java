package trees;

//LC-101
public class SymmetricTree {

    //Time complexity - O(N)
    //Space Complexity - O(N)
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if((a == null && b != null) || (a != null && b == null)){
            return false;
        }
        if(a.val == b.val){
            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }else{
            return false;
        }
    }
}


