package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC-199
public class BinaryTreeRightSideView {

    //Time Complexity - O(N) where N is the total number of nodes
    //Space Complexity - O(D) to keep the queues, where D is a tree diameter
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList();
        if(root == null){
            return out;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0; i<count; i++){
                TreeNode temp = q.remove();
                if(i == count - 1){//Adding only the last element for each level in the list
                    out.add(temp.val);
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return out;
    }
}
