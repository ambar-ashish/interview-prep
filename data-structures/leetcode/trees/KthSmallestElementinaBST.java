package trees;

import java.util.ArrayList;
import java.util.List;

//LC-230
public class KthSmallestElementinaBST {

    //Time complexity : O(N) to build a traversal.
    //Space complexity : O(N) to keep an inorder traversal
    List<Integer> list = new ArrayList();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k-1);
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
