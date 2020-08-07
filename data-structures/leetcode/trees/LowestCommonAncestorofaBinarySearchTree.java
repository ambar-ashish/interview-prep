package trees;

//LC-235
public class LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;

        while(temp != null){
            if(p.val > temp.val && q.val > temp.val){
                temp = temp.right;
            }else if(p.val < temp.val && q.val < temp.val){
                temp = temp.left;
            }else{
                return temp;
            }
        }
        return null;
    }

}
