package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC-107
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> output = new LinkedList();
        if(root == null){
            return output;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> list = new ArrayList();
            for(int i=0; i<count; i++){
                TreeNode temp = q.remove();
                list.add(temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            output.addFirst(list);//using addFirst for making sure we get the required order
        }
        return output;
    }
}
