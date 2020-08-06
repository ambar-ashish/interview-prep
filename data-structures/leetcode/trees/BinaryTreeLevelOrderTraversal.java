package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC-102
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            //count the number of nodes in current level
            int count = q.size();
            List<Integer> tempList = new ArrayList();
            //process the numbers of nodes in current level
            for(int i=0 ; i<count ; i++){
                TreeNode temp = q.remove();
                if(temp != null){
                    tempList.add(temp.val);
                    if(temp.left != null){
                        q.add(temp.left);//adding the nodes for next level in queue
                    }
                    if(temp.right != null){
                        q.add(temp.right);//adding the nodes for next level in queue
                    }
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
